<template>
  <div>
    <blockquote class="twitter-tweet" data-lang="en" data-theme="light">
      <p lang="en" dir="ltr">
        For everyone&#39;s safety,
        <a
          href="https://twitter.com/hashtag/vueconfus?src=hash&amp;ref_src=twsrc%5Etfw"
          >#vueconfus</a
        >
        2021 will be virtual . We hope you&#39;ll join
        <a href="https://twitter.com/youyuxi?ref_src=twsrc%5Etfw">@youyuxi</a>,
        the Core
        <a href="https://twitter.com/vuejs?ref_src=twsrc%5Etfw">@vuejs</a> team,
        community experts &amp; the worldwide
        <a
          href="https://twitter.com/hashtag/VueJS?src=hash&amp;ref_src=twsrc%5Etfw"
          >#VueJS</a
        >
        community for this event on April 14<br /><br />Please visit the site to
        submit to the
        <a
          href="https://twitter.com/hashtag/cfp?src=hash&amp;ref_src=twsrc%5Etfw"
          >#cfp</a
        >
        &amp; register for FREE<a href="https://t.co/jbhXYquxJR"
          >https://t.co/jbhXYquxJR</a
        >
        <a href="https://t.co/RPxizZRNVP">pic.twitter.com/RPxizZRNVP</a>
      </p>
      &mdash; Vueconf.US (@vueconfus)
      <a
        href="https://twitter.com/vueconfus/status/1328321931838320646?ref_src=twsrc%5Etfw"
        >November 16, 2020</a
      >
    </blockquote>
  </div>
</template>

<script>
export default {
  name: "TwitterStatus",
  props: {},
  mounted() {
    let recaptchaScript = document.createElement("script");
    recaptchaScript.setAttribute(
      "src",
      "https://platform.twitter.com/widgets.js"
    );
    document.head.appendChild(recaptchaScript);
  },
};
</script>

<style scoped>
</style>
