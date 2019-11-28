import VueRouter from "vue-router"
import cart from "../components/Cart"
import order from "../components/Order"

const router = new VueRouter({
    // 애플리케이션에서 사용되는 모든 경로 정보를 저장하는 배열
    routes: [
        // {
        //     name : "경로에 대한 예명",
        //     path : "요청하는 경로", 
        //     component : "표시해줄 컴포넌트"
        // }
        {
            name:"/", 
            path:"/", 
            component:cart
        }, 
        {
            name:"order", 
            path:"/order/:id",  
            component:order
        }
    ]

})

export default router // 누구든지 router.js 를 import 하면 router 객체를 사용할 수 있음