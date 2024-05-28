const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot87gha/",
            name: "springboot87gha",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot87gha/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "宠物领养系统"
        } 
    }
}
export default base
