<template>
  <div>
    <form>
      <div class="form-group">
        <label class="label-margin" for="exampleInputEmail1"
          >Email address</label
        >
        <input
          type="email"
          class="form-control"
          id="exampleInputEmail1"
          aria-describedby="emailHelp"
          placeholder="Enter email"
        />
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Phone number</label>
        <input
          type="tel"
          class="form-control"
          id="exampleInputPassword1"
          placeholder="Phone number"
        />
      </div>
      <div class="form-group">
        <label for="exampleFormControlTextarea1">Example textarea</label>
        <textarea
          class="form-control"
          id="exampleFormControlTextarea1"
          rows="3"
        ></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "ContactForm",
  props: {},
  mounted() {},
};
</script>

<style scoped>
.label-margin {
  margin-top: 10px;
}
</style>
