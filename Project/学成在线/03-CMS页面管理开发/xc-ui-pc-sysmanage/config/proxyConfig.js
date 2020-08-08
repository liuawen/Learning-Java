// let ApiBaseURL = 'https://easy-mock.com/mock/59802015a1d30433d84f1a02/v1'
// let ApiBaseURL = 'http://plab.itcast.cn:7999'
// let ApiBaseURL = 'http://dev.plab.itcast.cn:7999'
let courseURL = 'http://localhost:3000/mock/11';
let BannerURL = 'http://localhost:3003';
module.exports = {
    proxyList: {
        '/banner/*': {
            target: BannerURL/*,
            changeOrigin: true,
            pathRewrite:{
                '^/banner':''
            }*/
        }
    }
}
