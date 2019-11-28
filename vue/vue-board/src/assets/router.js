import VueRouter from 'vue-router'
import Board from '../components/Board.vue'
import PostComponent from '../components/PostComponent.vue'
import InsertBoard from '../components/InsertBoard.vue'
import ModifyBoard from '../components/ModifyBoard.vue'

const router = new VueRouter({
    // 경로 정보 저장 배열
    routes: [
        {
            name: 'board',
            path: '/board',
            alias: '/',
            component: Board,
            props: true,
        },
        {
            name: 'postComponent',
            path: '/postComponent/:id',
            component: PostComponent,
            props: true,
        },
        {
            name: 'insertPost',
            path: '/insertPost',
            component: InsertBoard,
            props: true,
        },
        {
            name: 'modifyPost',
            path: '/modifyPost/:id',
            component: ModifyBoard,
            props: true,
        }
    ],

})

export default router