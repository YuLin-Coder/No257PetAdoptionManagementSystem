import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import AddrList from '../pages/shop-address/list'
import AddrAdd from '../pages/shop-address/addOrUpdate'
import Order from '../pages/shop-order/list'
import OrderConfirm from '../pages/shop-order/confirm'
import Cart from '../pages/shop-cart/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import chongwufenleiList from '../pages/chongwufenlei/list'
import chongwufenleiDetail from '../pages/chongwufenlei/detail'
import chongwufenleiAdd from '../pages/chongwufenlei/add'
import chongwuxinxiList from '../pages/chongwuxinxi/list'
import chongwuxinxiDetail from '../pages/chongwuxinxi/detail'
import chongwuxinxiAdd from '../pages/chongwuxinxi/add'
import chongwulingyangList from '../pages/chongwulingyang/list'
import chongwulingyangDetail from '../pages/chongwulingyang/detail'
import chongwulingyangAdd from '../pages/chongwulingyang/add'
import chongwuyongpinList from '../pages/chongwuyongpin/list'
import chongwuyongpinDetail from '../pages/chongwuyongpin/detail'
import chongwuyongpinAdd from '../pages/chongwuyongpin/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'messages',
					component: Messages
				},
                {
                    path: 'shop-address/list',
                    component: AddrList
                },
                {
                    path: 'shop-address/addOrUpdate',
                    component: AddrAdd
                },
				{
					path: 'shop-order/order',
					component: Order
				},
				{
					path: 'cart',
					component: Cart
				},
				{
					path: 'shop-order/orderConfirm',
					component: OrderConfirm
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'chongwufenlei',
					component: chongwufenleiList
				},
				{
					path: 'chongwufenleiDetail',
					component: chongwufenleiDetail
				},
				{
					path: 'chongwufenleiAdd',
					component: chongwufenleiAdd
				},
				{
					path: 'chongwuxinxi',
					component: chongwuxinxiList
				},
				{
					path: 'chongwuxinxiDetail',
					component: chongwuxinxiDetail
				},
				{
					path: 'chongwuxinxiAdd',
					component: chongwuxinxiAdd
				},
				{
					path: 'chongwulingyang',
					component: chongwulingyangList
				},
				{
					path: 'chongwulingyangDetail',
					component: chongwulingyangDetail
				},
				{
					path: 'chongwulingyangAdd',
					component: chongwulingyangAdd
				},
				{
					path: 'chongwuyongpin',
					component: chongwuyongpinList
				},
				{
					path: 'chongwuyongpinDetail',
					component: chongwuyongpinDetail
				},
				{
					path: 'chongwuyongpinAdd',
					component: chongwuyongpinAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
