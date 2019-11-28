<template>
    <div class='container'>
        <h2>{{post.title}}</h2>
        <hr>
        <div>
            <span>글쓴이 : </span>
            <span>{{post.id}}</span>
        </div>
        <div>
            <span>작성시간 : </span>
            <span>{{post.regdate}}</span>
        </div>
        <div>
            <p>
                {{post.contents}}
            </p>
        </div>
        <hr>
        <p>코멘트<p>
        <table class="table table-hover">
            <tr>
                <th>댓글번호</th>
                <th>글쓴이</th>
                <th>내용</th>
                <th></th>
            </tr>
            <tr v-for="comment in comments" :key='comment.no'>
                <td>{{comment.comm_no}}</td>
                <td>{{comment.id}}</td>
                <td>{{comment.comments}}</td>
                <td><button v-if='comment.id == userId' class="btn btn-default" @click='deleteComment(comment.comm_no)'>삭제</button></td>
            </tr>
            <tr v-if='comments.length == 0'>
                <td></td>
                <td>댓글이 없습니다</td>
                <td></td>
            </tr>
        </table>
        <div>
            <input type="text" v-model='newComment'><button class="btn btn-default" @click='addComment'>댓글쓰기</button>
        </div>
        <hr>
        <button class="btn btn-default" @click='goBack'>목록으로</button>
        <button v-if='post.id == userId' class="btn btn-default" @click='modifyPost'>수정</button>
        <button v-if='post.id == userId' class="btn btn-default" @click='deletePost'>삭제</button>

    </div>
</template>

<script>

import axios from 'axios'
import router from '../assets/router.js'

export default {
    props:[
        "id",
    ],
    data() {
        return {
            post: {},
            comments: [],
            newComment: "",
        }
    },
    methods: {
        goBack(){
            router.push({
                path:'/board',
            })
        },
        modifyPost(){
            router.push({
                path:'/modifyPost/'+this.id,
            })
        },
        deletePost(){
            axios.delete("http://localhost:8197/safefoodvue/api/deleteBoard/"+ this.id)
                .then(() => {
                    router.push({
                        path:'/board'
                    })
                })
                .catch(error => {
                    console.log(error);
                })
        },
        addComment(){
            axios.post("http://localhost:8197/safefoodvue/api/insertComment",{
                "board_no": this.id,
                "comments": this.newComment,
                "id": this.userId
            }).then(() =>{
                alert("댓글 등록!");
                this.comments.push({
                    "comments": this.newComment,
                    "id": this.userId,
                    "comm_no": this.id          //이거 원래 코멘트아이디가 나와야되는데 글 아이디가 나온다 ㅎ..
                })
                this.newComment = "";
            }).catch(error => {
                console.log(error);
            })
        },
        deleteComment(id){          
            axios.delete("http://localhost:8197/safefoodvue/api/deleteComment", {
                data: {
                    "id": this.userId,
                    "comm_no": id,
                    "board_no": this.id
                }
            }).then(() =>{
                alert("댓글 삭제 완료!");
                //refresh해야함
                let idx = this.comments.findIndex(el => el.comm_no == id);
                this.comments.splice(idx, 1);
            }).catch(error => {
                console.log(error);
            })
        }
    },
    computed: {
        userId(){
            return this.$store.state.userId;
        }
    },
    mounted() {
        axios.get("http://localhost:8197/safefoodvue/api/searchBoard/"+ this.id)
            .then(response => {
                this.post = response.data;
            })
            .catch(error => {
                console.log(error);
            })
            .finally()
        axios.get("http://localhost:8197/safefoodvue/api/searchCommentsByNo/"+ this.id)
            .then(response => {
                this.comments = response.data;
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