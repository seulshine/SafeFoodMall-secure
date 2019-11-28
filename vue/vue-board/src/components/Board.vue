<template>
    <div class='container'>
        <h2>공지사항</h2>
        <table class="table table-hover">
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>게시일</th>
            </tr>
            <tr v-for="post in posts" :key='post.no' @click="goDetail(post.no)">
                <td>{{post.no}}</td>
                <td>{{post.title}}</td>
                <td>{{post.id}}</td>
                <td>{{post.regdate}}</td>
            </tr>
        </table>
        <div v-show='isLogined == true'>
            <button class="btn btn-default" @click='goInsert'>글쓰기</button>
        </div>
    </div>
</template>

<script>
import router from '../assets/router.js'
import axios from 'axios'

export default {
    data() {
        return {
            posts: [],
            isLogined: true,
        }
    },
    methods: {
        goDetail(id){
            router.push({
                path:'/postComponent/' + id,
            })
        },
        goInsert(){
            router.push({
                path:'/insertPost',
            })
        }
    },
    computed: {
        userId(){
            return this.$store.state.userId;
        }
    },
    mounted() {
        axios.get("http://localhost:8197/safefoodvue/api/searchAllBoard")
            .then(response => {
                this.posts = response.data;
            })
            .catch(error => {
                console.log(error);
            })
            .finally()

        axios.get("http://localhost:8197/safefoodvue/api/getLoginedUser")
            .then(response => {
                if(response.data == null){
                    this.isLogined = false;
                    // this.isLogined = true;
                    // this.$store.commit('putUserId', {userId: "hdw"});
                } else {
                    this.isLogined = true;
                    // this.userid = response.data;
                    this.$store.commit('putUserId', {userId: response.data});
                }
                console.log(response);
                
            })
            .catch(error => {
                console.log(error);
            })
            .finally() 
    },
}
</script>

<style>

</style>