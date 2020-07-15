package demo.sixth

import com.alibaba.fastjson.JSON

class ScriptTest {

    def static main(args) {
        def dataStr = '{"auto":"1","img":"{}","extension":"{\\"source\\":{\\"fromApp\\":\\"trade-core\\",\\"source\\":0},\\"operator\\":{\\"operatorId\\":12303369,\\"role\\":\\"buyer\\"},\\"extraMap\\":{}}","buyer_tax_info":"{\\"taxpayerId\\":\\"91110106MA003K614D\\",\\"userName\\":\\"中质国认（北京）计量科学研究院\\",\\"raiseType\\":\\"enterprise\\"}","sms_setting":"{\\"emailList\\":[\\"Sophiazuozuo@163.com\\"]}","invoice_asset_id":"20190426180114011017","created_at":"2019-09-25 06:44:53","red_invoice":"0","kdt_id":"13328377","updated_at":"2019-09-25 06:44:53","sharding_id":"22","biz_no":"E20190901174429002200005","check_code":"","invoice_id":"20190925064453010022","invoice_success_date":"2010-01-01 00:00:00","invoice_type":"1","id":"1541314308421451777","invoice_detail_type":"itemDetail","error_msg":"","expires_date":"2019-09-25 06:44:53","invoice_no":"","blue_invoice_id":"","invoice_tag":"16","version":"1569365093884","invoice_code":"","pdf":"{}","goods_list_file":"{}","invalid":"0","status":"1"}'
        def data = JSON.parse(dataStr)
        exec(data)
    }

    private static threadlcoalFormat = ThreadLocal.withInitial({return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")} as java.util.function.Supplier)


    def static exec(data) {
        data.invoice_status_code = data.status
        data.invoice_status_type_code = data.red_invoice
        data.create_time = threadlcoalFormat.get().parse(data.created_at.toString()).getTime()/1000L

        def jsonSlurper = new groovy.json.JsonSlurper()
        data.operator = jsonSlurper.parseText(data.extension)?.operator?.role
        data.operator_id = jsonSlurper.parseText(data.extension)?.operator?.operatorId
        data.invoice_file = data.pdf
        data.is_red_freshed = data.invoice_status_type_code.toInteger() == 0 && data.invoice_status_code.toInteger() == 40
        if (null == data.biz_no || "".equals(data.biz_no)) {
            data.order_no = ""
            data.order_shard_id = 1
        } else {
            data.order_no = data.biz_no
            data.order_shard_id = data.order_no.substring(15, 19).toInteger()
        }
        data.source = jsonSlurper.parseText(data.extension)?.source?.source
        def parent_kdt_id = jsonSlurper.parseText(data.extension) != null && jsonSlurper.parseText(data.extension)?.extraMap != null ?
                            jsonSlurper.parseText(data.extension)?.extraMap.RETAIL_PARENT_KDT_ID : null
        data.head_kdt_id = parent_kdt_id != null ? Long.parseLong(parent_kdt_id) : data.kdt_id
    }
}