<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Hello</router-link> |
      <router-link to="/callservice">This is your navbar!</router-link> |
      <router-link to="/bootstrap">Contact</router-link> |
      <!-- <router-link to="/user">User</router-link> |
      <router-link to="/login">Login</router-link> |
      <router-link to="/protected">Protected</router-link> -->
    </div>
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'app',
  props: {
    msg: 'Test'
  }

}
</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 20px;
}

#nav {
  padding: 25px;
  a {
    font-weight: bold;
    color: #2c3e50;
    &.router-link-exact-active {
     color:  #007bff;;
    }
  }
}

</style>
