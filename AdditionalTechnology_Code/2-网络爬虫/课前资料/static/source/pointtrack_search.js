var trackPoints = {
    'searchTrackButtonClick': {
        trackType: '1',
        elementsStr: "[track-type='searchTrackButtonClick']",
        paramsRank: ["logCode", "webId", "version", "logTime", "ip", "guid", "domain", "pageCode", "eventType","traceName", "cusParam"],
        params: {
            logCode: "81",
            webId: "2",
            version: "1",
            domain: 'search.51job.com',
            traceName: ''
        },
        dealParamsBeforeEvent: function(params){
            params['pageCode'] = $("#pageCode").val();
            params['logTime'] = new Date().getTime() + d_system_client_time;
            params['ip'] = trackConfig.ip;
            params['guid'] = trackConfig.guid;
            params['cusParam'] = ["1", trackConfig.accountid].join(String.fromCharCode(22));
            
            return params;
        },
        dealParamsAfterEvent: function(params, e){
            params['eventType'] = $(e).attr('event-type');
            return params;
        }
    },
    'searchConditionTrackButtonClick': {
        trackType: '1',
        elementsStr: "[track-type='searchConditionTrackButtonClick']",
        paramsRank: ["logCode", "webId", "version", "logTime", "ip", "guid", "domain", "pageCode", "eventType","traceName", "cusParam"],
        params: {
            logCode: "81",
            webId: "2",
            version: "1",
            domain: 'search.51job.com',
            traceName: ''
        },
        dealParamsBeforeEvent: function(params){
            params['pageCode'] = $("#pageCode").val();
            params['logTime'] = new Date().getTime() + d_system_client_time;
            params['ip'] = trackConfig.ip;
            params['guid'] = trackConfig.guid;
            
            return params;
        },
        dealParamsAfterEvent: function(params, e){
            params['eventType'] = $(e).attr('event-type');
            params['cusParam'] = ["1", trackConfig.accountid,$(e).text()].join(String.fromCharCode(22));
            return params;
        }
    },
    'adTrackButtonClick': {
        trackType: '1',
        elementsStr: "[track-type='adTrackButtonClick']",
        paramsRank: ["logCode", "webId", "version", "logTime", "ip", "guid", "domain", "pageCode", "eventType","traceName", "cusParam"],
        params: {
            logCode: "81",
            webId: "2",
            version: "1",
            domain: 'search.51job.com',
            traceName: ''
        },
        dealParamsBeforeEvent: function(params){
            params['pageCode'] = $("#pageCode").val();
            params['logTime'] = new Date().getTime() + d_system_client_time;
            params['ip'] = trackConfig.ip;
            params['guid'] = trackConfig.guid;
            params['cusParam'] = ["1", trackConfig.accountid, $("#kwdselectid").val(), $("#jobarea").val(), $("#coad_companyid").val()].join(String.fromCharCode(22));
            
            return params;
        },
        dealParamsAfterEvent: function(params, e){
            params['eventType'] = $(e).attr('event-type');
            return params;
        }
    },
    'adShowManualTrack': {
        trackType: '3',
        elementsStr: '',
        paramsRank: ["logCode", "webId", "version", "logTime", "ip", "guid", "domain", "pageCode", "eventType","traceName", "cusParam"],
        params: {
            logCode: "81",
            webId: "2",
            version: "1",
            domain: 'search.51job.com',
            pageCode: '10101',
            traceName: '',
            eventType: '4'
        },
        dealParamsBeforeEvent: function(params){
            params['logTime'] = new Date().getTime() + d_system_client_time;
            params['ip'] = trackConfig.ip;
            params['guid'] = trackConfig.guid;
            
            return params;
        }
    },
    'reBindTrackbuttonClick': {
        trackType: '4',
        elementsStr: "[track-type='reBindTrackButtonClick']",
        paramsRank: ["logCode", "webId", "version", "logTime", "ip", "guid", "domain", "pageCode", "eventType","traceName", "cusParam"],
        params: {
            logCode: "81",
            webId: "2",
            version: "1",
            domain: 'search.51job.com',
            traceName: '',
        },
        dealParamsBeforeEvent: function(params){
            params['ip'] = trackConfig.ip;
            params['guid'] = trackConfig.guid;
            params['pageCode'] = $("#pageCode").val();
            params['cusParam'] = "1" + String.fromCharCode(22) + trackConfig.accountid;
            
            return params;
        },
        dealParamsAfterEvent: function(params, e){
            params['eventType'] = $(e).attr('event-type');
            params['logTime'] = new Date().getTime() + d_system_client_time;
            return params;
        }
    },
    'manualTrackbuttonClick': {
        trackType: '4',
        elementsStr: "",
        paramsRank: ["logCode", "webId", "version", "logTime", "ip", "guid", "domain", "pageCode", "eventType","traceName", "cusParam"],
        params: {
            logCode: "81",
            webId: "2",
            version: "1",
            domain: 'search.51job.com',
            traceName: '',
        },
        dealParamsBeforeEvent: function(params){
            params['ip'] = trackConfig.ip;
            params['guid'] = trackConfig.guid;
            params['pageCode'] = $("#pageCode").val();
            params['cusParam'] = "1" + String.fromCharCode(22) + trackConfig.accountid;
            params['logTime'] = new Date().getTime() + d_system_client_time;
            
            return params;
        }
    }
}