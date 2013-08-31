/**
 * Created with JetBrains WebStorm.
 * User: 可乐加糖
 * Date: 13-8-18
 * Time: 下午1:29
 * 金色梯田后台发布系统文章发布管理插件
 */

Ext.define('tt.plugin.article', {
    extend: 'Ext.window.Window',
    height: 560,
    width: 760,
    modal:true,
    layout: {
        type: 'fit'
    },
    url:'',
    title: '发布文章',
    initComponent: function() {
        var me = this;
        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    id:'article_frm',
                    defaults: {
                        xtype:'textfield',
                        labelSeparator:'：',
                        labelWidth:50
                    },
                    bodyPadding: 10,
                    title: '',
                    items: [
                        {
                            width: 705,
                            fieldLabel: '标题',
                            labelWidth: 50,
                            allowBlank:false,
                            emptyText:'请输入文章标题',
                            maxLengthText:10
                        },
                        {
                            xtype: 'textareafield',
                            anchor: '100%',
                            id:'textarea_body',
                            height: 430,
                            width: 700,
                            fieldLabel: '内容',
                            labelWidth: 50
                        }
                    ],
                    listeners:{
                        'render':function(){
                            setTimeout(function () {
                                var editor = KindEditor.create('#textarea_body-inputEl', {
                                    width:320,
                                    allowFileManager: true
                                    //uploadJson: root_path + '/fileupload/upload'
                                });
                                //载入KindEditor
                            },500);}
                    },
                    buttons:[
                        {
                            text:'确定',
                            scope:this,
                            handler:function(){
                                Ext.getCmp('article_frm').submit({
                                    clientValidation:true,
                                    url:this.url,
                                    method:'post',
                                    success:function(form,action){
                                        top.Ext.Msg.alert("提示","操作成功，新的数据已经被录入。");
                                    },
                                    failure:function(form,action){
                                        Ext.Msg.alert("提示","数据提交失败");
                                        throw new Error("数据保存失败，请检查服务器端返回");
                                    }
                                });
                            }
                        }
                    ]
                }
            ]
        });
        me.callParent(arguments);
    }
});