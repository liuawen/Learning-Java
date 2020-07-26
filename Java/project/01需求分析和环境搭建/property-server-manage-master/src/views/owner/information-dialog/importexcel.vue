<template>
  <div>
    <a-modal title="导入业主信息(Excel)到数据库" width="50%" v-model="visibleObj.importexcelvisible">
      <a-form-model :label-col="labelCol" :wrapper-col="wrapperCol">
        <a-row>
          <a-col :span="8">
            <a-form-model-item label="所属公司" :labelCol="{span: 10}" :wrapperCol="{span: 14}">
              <a-select>
                <a-select-option value="1">所属公司xx</a-select-option>
                <a-select-option value="2">所属公司cc</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>

          <a-col :span="8" offset="2">
            <a-button class="importExcel">上传Excel模版</a-button>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="8">
            <a-form-model-item label="选择Excel文档" :labelCol="{span: 10}" :wrapperCol="{span: 14}">
              <a-upload :fileList="fileList" :remove="handleRemove" :beforeUpload="beforeUpload">
                <a-button>
                  <a-icon type="upload" />选择上传文件
                </a-button>
              </a-upload>
            </a-form-model-item>
          </a-col>
          <a-col :span="3" offset="2">
            <a-button
              type="primary"
              @click="handleUpload"
              :disabled="fileList.length === 0"
              :loading="uploading"
              style="margin-top: 4px;"
            >{{ uploading ? '上传中' : '开始上传' }}</a-button>
          </a-col>
          <a-col :span="6">
            <a-button style="margin-top: 4px;" @click="handleCancel">关闭</a-button>
          </a-col>
        </a-row>
      </a-form-model>
    </a-modal>
  </div>
</template>

<script>
import reqwest from 'reqwest' // ajax上传插件
export default {
    props: {
        visibleObj: {
            type: Object,
            default: () => {
                return {
                    importexcelvisible: false
                }
            }
        }
    },
    data() {
        return {
            labelCol: { lg: { span: 6 }, sm: { span: 6 } },
            wrapperCol: { lg: { span: 18 }, sm: { span: 18 } },
            fileList: [],
            uploading: false
        }
    },
    methods: {
        handleCancel(e) {
            this.visibleObj.importexcelvisible = false
        },
        handleRemove(file) {
            const index = this.fileList.indexOf(file)
            const newFileList = this.fileList.slice()
            newFileList.splice(index, 1)
            this.fileList = newFileList
        },
        beforeUpload(file) {
            this.fileList = [...this.fileList, file]
            return false
        },
        handleUpload() {
            const { fileList } = this
            const formData = new FormData()
            fileList.forEach(file => {
                formData.append('files[]', file)
            })
            this.uploading = true

            // 上传
            reqwest({
                url: 'https://www.mocky.io/v2/5cc8019d300000980a055e76',
                method: 'post',
                processData: false,
                data: formData,
                success: () => {
                    this.fileList = []
                    this.uploading = false
                    this.$message.success('upload successfully.')
                },
                error: () => {
                    this.uploading = false
                    this.$message.error('upload failed.')
                }
            })
        }
    }
}
</script>

<style lang="less" scoped>
.importExcel {
    margin-top: 4px;
}
.ant-upload .ant-btn{
    width: 100%;display: block;
}
</style>
