<template>
    <div class='container'>
        <h3>공지사항 작성</h3>
        <div class="form-group" style="text-align:left;">
            <label for="title" >제목</label>
            <input type="text" class="form-control" id="title" v-model='title' placeholder="제목">
        </div>
        <div style="text-align:left;">
            <label for="contents">내용</label>
            <textarea class="form-control" id='contents' v-model='contents' rows="15"></textarea>
        </div>
        <button class="btn btn-default" @click="insertPost">올리기</button>
        <button class="btn btn-default" @click="goBack">뒤로</button>
    </div>
</template>

<script>
import axios from 'axios'
import router from '../assets/router.js'

export default {
    data() {
        return {
            title: "",
            contents: "",
        }
    },
    methods: {
        insertPost(){
            axios.post("http://localhost:8197/safefoodvue/api/insertBoard",{
                "contents": this.contents,
                "id": this.userId,
                "title": this.title,
            }).then(response => {
                console.log(response);
            }).catch(e => {
                console.log(e);
            }).finally(()=>{
                router.push({
                    path:'/board'
                })
            })
        },
        goBack(){
            router.push({
                path:'/board'
            })
        }
    },
    computed: {
        userId(){
            return this.$store.state.userId;
        }
    },
    mounted() {
        console.log(this.id);
        
    },
}
</script>

<style>

</style>