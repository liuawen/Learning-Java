//引入Trailers
const Trailers = require('../../model/Trailers');

module.exports = async data => {
  
  for (var i = 0; i < data.length; i++) {
    let item = data[i];
  
    await Trailers.create({
      title: item.title,
      rating: item.rating,
      runtime: item.runtime,
      directors: item.directors,
      casts: item.casts,
      image: item.image,
      doubanId: item.doubanId,
      cover: item.cover,
      genre: item.genre,
      summary: item.summary,
      releaseDate: item.releaseDate,
      link: item.link,
    })
  
    console.log('数据保存成功');
    
  }
  
}