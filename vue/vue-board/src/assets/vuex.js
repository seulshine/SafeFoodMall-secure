import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex);

const store = new Vuex.Store({
    state:{
        userId: "",

    },
    mutations: {
        // state, payload
        // putPostList(state, payload){
        //     state.posts = payload.data;
        // },
        putUserId(state, payload){
            state.userId = payload.userId;
        }

    },
    actions: {
        // store(context), payload
        // action_name(state, payload){
        //     //비동기작업 진행 후 mutation을 호출해서 state를 바꾼다.
        //     store.commit(Constant.COUNT_INCREMENT, payload);
        // },
        // getPostList(state, payload){
        //     store.commit('putPostList', payload);
        // }

    }
})

export default store;