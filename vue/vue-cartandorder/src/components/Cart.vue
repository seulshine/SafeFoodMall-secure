<template>
  <div>
    <table>
      <tr style="vertical-align: top">
        <td style="text-align: center">
          <h2>Shopping Cart</h2>
          <form action method="post">
            <table id="cart">
              <tr>
                <th>상품이미지</th>
                <th>상품이름</th>
                <th>주문수량</th>
                <th>상품가격</th>
                <th>전체가격</th>
                <th>삭제</th>
              </tr>
              <tr v-if="carts.length == 0">
                <td colspan="8">
                  <b>Your cart is empty.</b>
                </td>
              </tr>

              <tr v-for="(cartItem) in carts" :key="cartItem.code" v-bind:value="cartItem.code">
                <td><img :src="'../'+cartItem.img" width="35%"></td>
                <td style="width:10%">{{cartItem.name}}</td>
                <td style="width:10%">{{cartItem.qty}}</td>
                <td style="width:10%">{{cartItem.price}}</td>
                <td style="width:10%">{{cartItem.qty * cartItem.price}}</td>
                <td><input type="button" value="삭제" @click="removefromcart(cartItem.code)" /></td>
              </tr>

              <tr>
                <td colspan="7" align="right">
                  <b>Total: {{totalItem}}</b>
                </td>
              </tr>
              <tr>
                <td colspan="7" align="right">
                  <input type="button" value="주문하기" @click="carttoorder()" />
                </td>
              </tr>
            </table>
          </form>
        </td>
      </tr>
    </table>
  </div>
</template>
<script>
import router from "../assets/router";
import axios from "../js/http-commons.js";
export default {
  data() {
    return {
      cart:{},
      id: "",
      carts: [],
      loading: false,
      mge_emps: []
    };
  },
  created() {
    axios
      .get("/api/getLoginedUser")
      .then(res => {
    this.id = res.data;
		console.log("id : " + this.id)
      }).then(() =>{
            axios
              .get("/cart/" + this.id)
              .then(res => {
                this.carts = res.data;
              })
              .catch(e => {
                console.log(e);
              })
              .finally(() => {
                this.loading = false;
              });
      })
      .catch(e => {
        console.log(e);
      })
      .finally(() => {
        this.loading = false;
      });
  },
  computed: {
    totalItem: function() {
      let sum = 0;
      for (let i = 0; i < this.carts.length; i++) {
        sum += parseFloat(this.carts[i].qty) * parseFloat(this.carts[i].price);
      }

      return sum;
    }
  },
  methods: {
    updateinstock(cart) {
      axios
          .put("/order/updateInstock" , {          
              "id": cart.id,
              "code": cart.code,
              "img" : cart.img,
              "name" : cart.name,
              "price" : cart.price,
              "qty" : cart.qty
          })
          .then(() => {
            //console.log(order)
              // - 재고 빼기!
            // cart 비우기
            axios
              .delete("/removeAllCart/" + this.id)
            })
            .then(() => {
        
              alert("주문 완료"); 
            })
            .catch(e => {
              console.log(e);
            })
            .finally(() => {
              this.loading = false;
          });
    },

    removefromcart(code) {
      console.log(this.id);
      console.log(code);
      axios
        .delete("/removeFromCart" , {
          data:{
            "id" : this.id,
            "code" : code
          }
        })
        .then(() => {
        
          alert("장바구니에서 상품을 삭제합니다"); 

            axios
              .get("/cart/" + this.id)
              .then(res => {
                this.carts = res.data;
              })
              .catch(e => {
                console.log(e);
              })
              .finally(() => {
                this.loading = false;
              });
        })

        .catch(error => {
          console.log(error);
          alert("상품 삭제 오류");
        })
        .finally(() => {
          console.log("끝~");
        });
    },
      insertOrder(cart) {
        console.log("insert:");
        console.log(cart);
       axios
          .post("/order/insertOrder" , {          
              "id": cart.id,
              "code": cart.code,
              "img" : cart.img,
              "name" : cart.name,
              "price" : cart.price,
              "qty" : cart.qty
          })
          .then(res => {
            //console.log(order)
              // - 재고 빼기!
              this.updateinstock(cart);
            // cart 비우기
            console.log(res);
            })
          .catch(e => {
              console.log(e);
            })
          .finally(() => {
              this.loading = false;
          });
    },

    carttoorder() {
        //console.log(this.carts);
        for(var i = 0; i < this.carts.length; i++) {
          this.cart=this.carts[i];
          //console.log(this.cart);
          this.insertOrder(this.cart);
        }

        router.push({
            path:"/order/" + this.id
        });
    },


    

  }
  
};
</script>

<style>
h2 {
  color:navy
}
th {
  color:cornflowerblue
}

b {
  font-size:18px;
  color:navy
}

hr {
  color:cornflowerblue
}
</style>