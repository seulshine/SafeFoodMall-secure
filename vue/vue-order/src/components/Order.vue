<template>
  <div>
    <table>
      <tr style="vertical-align: top">
        <td style="text-align: center">
          <h2>Order List</h2>
          <form action method="post">
            <table id="order">
              <tr>
                <th>상품이미지</th>
                <th>상품이름</th>
                <th>주문수량</th>
                <th>상품가격</th>
                <th>전체가격</th>
              </tr>
              <tr v-if="orders.length == 0">
                <td colspan="8">
                  <b>Your order is empty.</b>
                </td>
              </tr>

              <tr v-for="(orderItem) in orders" :key="orderItem.no" v-bind:value="orderItem.code">
                <td>
                  <img :src="'../'+orderItem.img" width="35%" />
                </td>
                <td style="width:10%">{{orderItem.name}}</td>
                <td style="width:10%">{{orderItem.qty}}</td>
                <td style="width:10%">{{orderItem.price}}</td>
                <td style="width:10%">{{orderItem.qty * orderItem.price}}</td>
              </tr>

              <tr>
                <td colspan="7" align="right">
                  <b>Total: {{totalItem}}</b>
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
import axios from "../js/http-commons.js";
export default {
  data() {
    return {
      order: {},
      id: "",
      orders: [],
      loading: false
    };
  },
  created() {
    axios
      .get("/api/getLoginedUser")
      .then(res => {
        this.id = res.data;
        console.log("id : " + this.id);
      })
      .then(() => {
        axios
          .get("/order/searchOrders/" + this.id)
          .then(res => {
            this.orders = res.data;
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
      for (let i = 0; i < this.orders.length; i++) {
        sum += parseFloat(this.orders[i].qty) * parseFloat(this.orders[i].price);
      }

      return sum;
    }
  }
};
</script>

<style>
</style>