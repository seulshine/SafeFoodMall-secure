(function(t){function e(e){for(var o,i,r=e[0],c=e[1],l=e[2],p=0,f=[];p<r.length;p++)i=r[p],Object.prototype.hasOwnProperty.call(a,i)&&a[i]&&f.push(a[i][0]),a[i]=0;for(o in c)Object.prototype.hasOwnProperty.call(c,o)&&(t[o]=c[o]);u&&u(e);while(f.length)f.shift()();return s.push.apply(s,l||[]),n()}function n(){for(var t,e=0;e<s.length;e++){for(var n=s[e],o=!0,r=1;r<n.length;r++){var c=n[r];0!==a[c]&&(o=!1)}o&&(s.splice(e--,1),t=i(i.s=n[0]))}return t}var o={},a={app:0},s=[];function i(e){if(o[e])return o[e].exports;var n=o[e]={i:e,l:!1,exports:{}};return t[e].call(n.exports,n,n.exports,i),n.l=!0,n.exports}i.m=t,i.c=o,i.d=function(t,e,n){i.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:n})},i.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},i.t=function(t,e){if(1&e&&(t=i(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var n=Object.create(null);if(i.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var o in t)i.d(n,o,function(e){return t[e]}.bind(null,o));return n},i.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return i.d(e,"a",e),e},i.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},i.p="";var r=window["webpackJsonp"]=window["webpackJsonp"]||[],c=r.push.bind(r);r.push=e,r=r.slice();for(var l=0;l<r.length;l++)e(r[l]);var u=c;s.push([0,"chunk-vendors"]),n()})({0:function(t,e,n){t.exports=n("56d7")},"034f":function(t,e,n){"use strict";var o=n("85ec"),a=n.n(o);a.a},"56d7":function(t,e,n){"use strict";n.r(e);n("e260"),n("e6cf"),n("cca6"),n("a79d");var o=n("2b0e"),a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"app"}},[n("router-view")],1)},s=[],i={name:"app"},r=i,c=(n("034f"),n("2877")),l=Object(c["a"])(r,a,s,!1,null,null,null),u=l.exports,p=(n("f9e3"),n("8c4f")),f=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"container"},[n("h2",[t._v("공지사항")]),n("table",{staticClass:"table table-hover"},[t._m(0),t._l(t.posts,(function(e){return n("tr",{key:e.no,on:{click:function(n){return t.goDetail(e.no)}}},[n("td",[t._v(t._s(e.no))]),n("td",[t._v(t._s(e.title))]),n("td",[t._v(t._s(e.id))]),n("td",[t._v(t._s(e.regdate))])])}))],2),n("div",{directives:[{name:"show",rawName:"v-show",value:1==t.isLogined,expression:"isLogined == true"}]},[n("button",{staticClass:"btn btn-default",on:{click:t.goInsert}},[t._v("글쓰기")])])])},d=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("tr",[n("th",[t._v("글번호")]),n("th",[t._v("제목")]),n("th",[t._v("글쓴이")]),n("th",[t._v("게시일")])])}],h=(n("d3b7"),n("bc3a")),v=n.n(h),_={data:function(){return{posts:[],userid:"",isLogined:!0}},methods:{goDetail:function(t){M.push({path:"/postComponent/"+t})},goInsert:function(){M.push({path:"/insertPost"})}},mounted:function(){var t=this;v.a.get("http://localhost:8197/safefoodvue/api/searchAllBoard").then((function(e){t.posts=e.data})).catch((function(t){console.log(t)})).finally(),v.a.get("http://localhost:8197/safefoodvue/api/getLoginedUser").then((function(e){null==e.data?t.isLogined=!1:(t.isLogined=!0,t.userid=e.data),console.log(e)})).catch((function(t){console.log(t)})).finally()}},m=_,b=Object(c["a"])(m,f,d,!1,null,null,null),g=b.exports,y=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"container"},[n("h2",[t._v(t._s(t.post.title))]),n("div",[n("span",[t._v("글쓴이 : ")]),n("span",[t._v(t._s(t.post.id))])]),n("div",[n("span",[t._v("작성시간 : ")]),n("span",[t._v(t._s(t.post.regdate))])]),n("div",[n("p",[t._v(" "+t._s(t.post.contents)+" ")])]),n("h3",[t._v("코멘트")]),n("table",{staticClass:"table table-hover"},[t._m(0),t._l(t.comments,(function(e){return n("tr",{key:e.no},[n("th",[t._v(t._s(e.comm_no))]),n("th",[t._v(t._s(e.id))]),n("th",[t._v(t._s(e.comments))])])}))],2),n("button",{staticClass:"btn btn-default",on:{click:t.goBack}},[t._v("목록으로")]),n("button",{staticClass:"btn btn-default",on:{click:t.modifyPost}},[t._v("수정")]),n("button",{staticClass:"btn btn-default",on:{click:t.deletePost}},[t._v("삭제")]),n("form",{attrs:{action:"post"}})])},w=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("tr",[n("th",[t._v("댓글번호")]),n("th",[t._v("글쓴이")]),n("th",[t._v("내용")])])}],C={props:["id"],data:function(){return{post:{},comments:[]}},methods:{goBack:function(){M.push({path:"/board"})},modifyPost:function(){console.log(this.id)},deletePost:function(){}},mounted:function(){var t=this;v.a.get("http://localhost:8197/safefoodvue/api/searchBoard/"+this.id).then((function(e){t.post=e.data})).catch((function(t){console.log(t)})).finally(),v.a.get("http://localhost:8197/safefoodvue/api/searchCommentsByNo/"+this.id).then((function(e){t.comments=e.data})).catch((function(t){console.log(t)})).finally()}},P=C,x=Object(c["a"])(P,y,w,!1,null,null,null),k=x.exports,O=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"container"},[n("h3",[t._v("공지사항 작성")]),n("div",{staticClass:"form-group",staticStyle:{"text-align":"left"}},[n("label",{attrs:{for:"title"}},[t._v("제목")]),n("input",{directives:[{name:"model",rawName:"v-model",value:t.title,expression:"title"}],staticClass:"form-control",attrs:{type:"text",id:"title",placeholder:"제목"},domProps:{value:t.title},on:{input:function(e){e.target.composing||(t.title=e.target.value)}}})]),n("div",{staticStyle:{"text-align":"left"}},[n("label",{attrs:{for:"contents"}},[t._v("내용")]),n("textarea",{directives:[{name:"model",rawName:"v-model",value:t.contents,expression:"contents"}],staticClass:"form-control",attrs:{id:"contents",rows:"15"},domProps:{value:t.contents},on:{input:function(e){e.target.composing||(t.contents=e.target.value)}}})]),n("button",{staticClass:"btn btn-default",on:{click:t.insertPost}},[t._v("올리기")]),n("button",{staticClass:"btn btn-default",on:{click:t.goBack}},[t._v("뒤로")])])},j=[],B={props:["id"],data:function(){return{title:"",contents:""}},methods:{insertPost:function(){v.a.post("http://localhost:8197/safefoodvue/api/insertBoard",{contents:this.contents,id:this.id,title:this.title}).then((function(t){console.log(t),M.push({path:"/board"})})).catch((function(t){console.log(t)})),M.push({path:"/board"})},goBack:function(){M.push({path:"/board"})}}},S=B,$=Object(c["a"])(S,O,j,!1,null,null,null),E=$.exports,L=new p["a"]({routes:[{name:"board",path:"/board",alias:"/",component:g,props:!0},{name:"postComponent",path:"/postComponent/:id",component:k,props:!0},{name:"insertPost",path:"/insertPost",component:E}]}),M=L;o["a"].config.productionTip=!1,o["a"].use(p["a"]),new o["a"]({router:M,render:function(t){return t(u)}}).$mount("#app")},"85ec":function(t,e,n){}});
//# sourceMappingURL=app.d7ad19b3.js.map