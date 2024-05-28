export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-camera","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["新增","查看","修改","删除"],"menu":"宠物分类","menuJump":"列表","tableName":"chongwufenlei"}],"menu":"宠物分类管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["新增","查看","修改","删除"],"menu":"宠物信息","menuJump":"列表","tableName":"chongwuxinxi"}],"menu":"宠物信息管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["查看","删除","审核"],"menu":"宠物领养","menuJump":"列表","tableName":"chongwulingyang"}],"menu":"宠物领养管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["新增","查看","修改","删除"],"menu":"宠物用品","menuJump":"列表","tableName":"chongwuyongpin"}],"menu":"宠物用品管理"},{"child":[{"appFrontIcon":"cuIcon-message","buttons":["查看","修改","回复","删除"],"menu":"留言板","tableName":"messages"}],"menu":"留言板"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"宠物资讯","tableName":"news"}],"menu":"系统管理"},{"child":[{"appFrontIcon":"cuIcon-camera","buttons":["查看","删除"],"menu":"已取消订单","tableName":"orders/已取消"},{"appFrontIcon":"cuIcon-phone","buttons":["查看","删除"],"menu":"已退款订单","tableName":"orders/已退款"},{"appFrontIcon":"cuIcon-circle","buttons":["查看","删除"],"menu":"未支付订单","tableName":"orders/未支付"},{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","物流"],"menu":"已发货订单","tableName":"orders/已发货"},{"appFrontIcon":"cuIcon-rank","buttons":["查看","删除","物流","发货"],"menu":"已支付订单","tableName":"orders/已支付"},{"appFrontIcon":"cuIcon-list","buttons":["查看"],"menu":"已完成订单","tableName":"orders/已完成"}],"menu":"订单管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","领养申请"],"menu":"宠物信息列表","menuJump":"列表","tableName":"chongwuxinxi"}],"menu":"宠物信息模块"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看"],"menu":"宠物用品列表","menuJump":"列表","tableName":"chongwuyongpin"}],"menu":"宠物用品模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["查看","修改","删除"],"menu":"宠物领养","menuJump":"列表","tableName":"chongwulingyang"}],"menu":"宠物领养管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","领养申请"],"menu":"宠物信息列表","menuJump":"列表","tableName":"chongwuxinxi"}],"menu":"宠物信息模块"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看"],"menu":"宠物用品列表","menuJump":"列表","tableName":"chongwuyongpin"}],"menu":"宠物用品模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
