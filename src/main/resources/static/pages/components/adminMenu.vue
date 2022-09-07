<template>
  <div>
    <template>
      <el-submenu index="dashboard" :popper-append-to-body="false">
        <template slot="title">
          <svg class="icon-svg aui-aside__menu-icon" aria-hidden="true">
            <use xlink:href="#icon-fire"></use>
          </svg>
          <span>{{ menuData.name }}</span>
        </template>
        <el-menu-item
          v-for="item in menuData.permission"
          :key="item.flag"
          :index="item.flag"
          @click="addNewTab($event,item.path)"
        >
          <svg class="icon-svg aui-aside__menu-icon" aria-hidden="true">
            <use xlink:href="#icon-home"></use>
          </svg>
          <span slot="title">{{ item.name }}</span>
        </el-menu-item>
      </el-submenu>
    </template>
  </div>
</template>

<script>
module.exports = {
  data() {
    return {
      menuData: this.$attrs.menudata,
    };
  },

  mounted() {},

  methods: {
    addNewTab: function ($event, url) {
      // iconClass 应该是根据元素获取的
      const item = {
        label: $event.$el.innerText,
        name: $event.index,
        iconClass: "el-icon-user",
        url: url,
      };
      // console.log(item)
      this.$emit('new-tab',item)
      // this.mainTabs.push(item);
      // this.mainTabsActive = item.name;
    },
  },
};
</script>

<style>
</style>