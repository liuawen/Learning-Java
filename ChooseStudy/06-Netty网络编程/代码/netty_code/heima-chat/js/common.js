
window.config = {
	// 服务器地址
	SERVER_URL: 'http://192.168.1.106:9000',
	// NETTY地址
	WS_URL: 'ws://192.168.1.106:9001/ws',
	// 默认小头像路径名
	DEFAULT_PIC_IMG: "/image/default_user_pic.png",
	// 默认大头像路径名
	DEFAULT_PIC_IMG_NORMAL: "/image/default_user_pic_normal.png",
	// 二维码图标路径名
	QR_CODE_ICON: "/image/qrcode.png",
	// 消息类型
	MSG_TYPE_CONN: 0,		// 连接
	MSG_TYPE_SEND: 1,		// 发送消息
	MSG_TYPE_REC: 2,		// 签收
	MSG_TYPE_KEEPALIVE: 3,	// 客户端保持心跳
	MSG_TYPE_RELOADFRIEND: 4	// 重新拉取好友
}

window.util = {
	/**
	 * 判断字符串是否为空
	 * @param {Object} str
	 */
	isEmpty: function(str) {
		if(str != null && str != "" && str != undefined) {
			return false;
		}
		else {
			return true;
		}
	},
	
	/**
	 * 封装AJAX请求
	 * @param {Object} url 相对链接：/user/login
	 * @param {Object} data 传送的数据
	 * @param {Object} callback 回调函数
	 */
	ajax: function(url, data, callback) {
		if(data == undefined || data == null) {
			data = {};
		}
		
		mui.ajax(config.SERVER_URL + url, {
			data: data,
			dataType: 'json',
			type: 'post',
			timeout: 10000,
			headers: {
				'Content-Type': 'application/json'
			},
			success: function(res) {
				console.log(JSON.stringify(res));
				if(callback != undefined && callback != null) {
					callback(res);
				}
			}
		});
	},	
	/**
	 * 保存用户信息
	 * @param {Object} user
	 */
	saveUser: function(user) {
		plus.storage.setItem("user", JSON.stringify(user));
	},
	
	/**
	 * 获取用户信息
	 */
	getUser: function () {
		return JSON.parse(plus.storage.getItem("user"));
	},
	
	/**
	 * 获取发送出去的消息体
	 * @param {Object} type 消息类型
	 * @param {Object} userid 我方用户id
	 * @param {Object} friendid 朋友用户id
	 * @param {Object} msg 消息
	 * @param {Object} msgid 消息id
	 * @param {Object} ext 扩展字段
	 */
	getMessage: function(type, userid, friendid, msg, msgid, ext) {
		return {
			type: type,
			chatRecord: {
				id: msgid,
				userid: userid,
				friendid: friendid,
				message: msg,
			},
			ext: ext
		};
	},
	/**
	 * 保存聊天记录 
	 * @param {Object} userid 当前用户id
	 * @param {Object} friendid 朋友用户id
	 * @param {Object} message 消息
	 * @param {Object} flag 是朋友的消息，还是用户自己的消息 1表示自己的，2表示朋友发送的
	 */
	saveChatRecord: function(userid, friendid, message, flag) {
		var key = "chat-" + userid + "-" + friendid;
		var chatRecordList = plus.storage.getItem(key);
		
		if(!this.isEmpty(chatRecordList)) {
			// 如果不为空
			chatRecordList = JSON.parse(chatRecordList);
		}
		else {
			chatRecordList = [];
		}
		
		// 创建聊天记录消息
		var chatRecord = {
			userid: userid,
			friendid: friendid,
			message: message,
			flag: flag
		};
		chatRecordList.push(chatRecord);
		console.log("保存聊天记录到本地  key" + key + " value:" + JSON.stringify(chatRecordList));
		plus.storage.setItem(key, JSON.stringify(chatRecordList));
	},
	/**
	 * 根据用户的id，朋友的id获取聊天记录
	 * @param {Object} userid
	 * @param {Object} friendid
	 */
	getChatRecord: function(userid, friendid) {
		var key = "chat-" + userid + "-" + friendid;
		var chatRecordList = plus.storage.getItem(key);
		
		if(!this.isEmpty(chatRecordList)) {
			// 如果不为空
			chatRecordList = JSON.parse(chatRecordList);
		}
		else {
			chatRecordList = [];
		}
		
		return chatRecordList;
	},	
	/**
	 * 删除好友聊天快照
	 * @param {Object} userid
	 * @param {Object} friendid
	 */
	removeChatSnapshot: function(userid, friendid) {
		var key = "chat-snapshot-" + userid;
		var chatSnapchatList = plus.storage.getItem(key);
		
		// 大key userid，小key friendid
		
		if(!this.isEmpty(chatSnapchatList)) {
			// 如果不为空
			console.log("添加聊天快照:friendid:" + friendid);
			chatSnapchatList = JSON.parse(chatSnapchatList);
			// 查找是否存在朋友的聊天快照
			for(var i = 0; i < chatSnapchatList.length; ++i) {
				if(chatSnapchatList[i].friendid == friendid) {
					// 删除该聊天快照
					chatSnapchatList.splice(i, 1);
					console.log("删除聊天快照:friendid:" + friendid);
					break;
				}
			}
			
		}
		
		plus.storage.setItem(key, JSON.stringify(chatSnapchatList));
	},
	/**
	 * 保存好友聊天快照 ，保存与朋友聊天的最后一条消息
	 * @param {Object} userid 当前用户id
	 * @param {Object} friendid 朋友用户id
	 * @param {Object} message 消息
	 * @param {Object} isRead 消息是否已读
	 */
	saveChatSnapshot: function(userid, friendid, message, isRead) {
		var key = "chat-snapshot-" + userid;
		var chatSnapchatList = plus.storage.getItem(key);
		
		// 大key userid，小key friendid
		
		if(!this.isEmpty(chatSnapchatList)) {
			// 如果不为空
			chatSnapchatList = JSON.parse(chatSnapchatList);
			// 查找是否存在朋友的聊天快照
			for(var i = 0; i < chatSnapchatList.length; ++i) {
				if(chatSnapchatList[i].friendid == friendid) {
					// 删除该聊天快照
					chatSnapchatList.splice(i, 1);
				}
			}
			
		}
		else {
		}
		chatSnapchatList = [];
		
		// 创建聊天快照消息
		var chatSnapshot = {
			friendid: friendid,
			message: message,
			flag: isRead
		};
		// 将消息插入到开头
		chatSnapchatList.unshift(chatSnapshot);
		plus.storage.setItem(key, JSON.stringify(chatSnapchatList));
	},
	
	/**
	 * 根据用户的id，朋友的id获取聊天快照
	 * @param {Object} userid
	 * @param {Object} friendid
	 */
	getChatSnapshot: function(userid) {
		var key = "chat-snapshot-" + userid;
		var chatSnapchatList = plus.storage.getItem(key);
		
		if(!this.isEmpty(chatSnapchatList)) {
			// 如果不为空
			chatSnapchatList = JSON.parse(chatSnapchatList);
		}
		else {
			chatSnapchatList = [];
		}
		
		console.log("聊天快照:" + JSON.stringify(chatSnapchatList));
		return chatSnapchatList;
	}
}

//————————————————————————————————————————————————————//
//
// 本地缓存相关
//
//————————————————————————————————————————————————————//
window.Cache = {
	// 从缓存中加载数据
	put: function(key, value) {
		plus.storage.setItem(key, JSON.stringify(value));
	},
	// 从缓存中加载数据
	get: function(key) {
		return JSON.parse(plus.storage.getItem(key));
	},
}
