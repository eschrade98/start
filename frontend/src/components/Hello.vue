<template>
  <div class="hello">
    <img style="width:250px" src="./../assets/logo.png">
    <h1>{{ hellomsg }}</h1>
    <h3>This site contains no stuff bro</h3>
  </div>
</template>

<script>
export default {
  name: 'hello, welcome to the website of the buisnesscoach!',
  props: { hellomsg: { type: String, required: true } }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
