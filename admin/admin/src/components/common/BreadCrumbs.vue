<template>
	<div class="breadcrumb-preview">
		<el-breadcrumb :style='{"fontSize":"14px"}' separator="Ξ">
			<transition-group name="breadcrumb" class="box">
				<el-breadcrumb-item v-for="(item,index) in levelList" :key="item.path">
					<span v-if="item.redirect==='noRedirect'||index==levelList.length-1" class="no-redirect">{{ item.name }}</span>
					<a v-else @click.prevent="handleLink(item)">{{ item.name }}</a>
				</el-breadcrumb-item>
			</transition-group>
		</el-breadcrumb>
	</div>
</template>

<script>
import pathToRegexp from 'path-to-regexp'
import { generateTitle } from '@/utils/i18n'
export default {
  data() {
    return {
      levelList: null
    }
  },
  watch: {
    $route() {
      this.getBreadcrumb()
    }
  },
  created() {
    this.getBreadcrumb()
  },
  methods: {
    generateTitle,
    getBreadcrumb() {
      // only show routes with meta.title
      let route = this.$route
      let matched = route.matched.filter(item => item.meta)
      const first = matched[0]
      matched = [{ path: '/index' }].concat(matched)

      this.levelList = matched.filter(item => item.meta)
    },
    isDashboard(route) {
      const name = route && route.name
      if (!name) {
        return false
      }
      return name.trim().toLocaleLowerCase() === 'Index'.toLocaleLowerCase()
    },
    pathCompile(path) {
      // To solve this problem https://github.com/PanJiaChen/vue-element-admin/issues/561
      const { params } = this.$route
      var toPath = pathToRegexp.compile(path)
      return toPath(params)
    },
    handleLink(item) {
      const { redirect, path } = item
      if (redirect) {
        this.$router.push(redirect)
        return
      }
      this.$router.push(path)
    },
  }
}
</script>

<style lang="scss" scoped>
	.el-breadcrumb {
		& /deep/ .el-breadcrumb__separator {
		  		  margin: 0 9px;
		  		  color: #ccc;
		  		  font-weight: 500;
		  		}
		
		& /deep/ .el-breadcrumb__inner a {
		  		  color: #333;
		  		  display: inline-block;
		  		}
		
		& /deep/ .el-breadcrumb__inner {
		  		  color: #999;
		  		  display: inline-block;
		  		}
	}
</style>
