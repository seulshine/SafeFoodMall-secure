<template>
    <div class='container'>
        <h3>공지사항 수정</h3>
        <div class="form-group" style="text-align:left;">
            <label for="title" >제목</label>
            <input type="text" class="form-control" id="title" v-model='title' placeholder="제목">
        </div>
        <div style="text-align:left;">
            <label for="contents">내용</label>
            <textarea class="form-control" id='contents' v-model='contents' rows="15"></textarea>
        </div>
        <button class="btn btn-default" @click="modifyPost">수정하기</button>
        <button class="btn btn-default" @click="goBack">뒤로</button>
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
            title: "",
            contents: "",
        }
    },
    computed: {
        userId(){
            return this.$store.state.userId;
        }
    },
    methods: {
        modifyPost(){
            axios.put("http://localhost:8197/safefoodvue/api/updateBoard",{
                // data: {
                    "contents": this.contents,
                    "id": this.userId,
                    "title": this.title,
                    "no": this.id
                // }
            }).then(response => {
                console.log(response);
                alert("업데이트 완료!")
                router.push({
                    path:'/board'
                })
            }).catch(e => {
                console.log(e);
            })
        },
        goBack(){
            router.push({
                path:'/board'
            })
        }
    },

    mounted() {
        console.log(this.id);
        axios.get("http://localhost:8197/safefoodvue/api/searchBoard/"+this.id)
            .then(response => {
                this.title = response.data.title;
                this.contents = response.data.contents;
                this.userId = response.data.userId;
                console.log(response);
            })
            .catch(e => {
                console.log(e);
            })
    },
}
</script>

<style>

</style>