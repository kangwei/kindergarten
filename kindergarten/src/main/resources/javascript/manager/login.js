/**
 * Created with JetBrains WebStorm.
 * User: 可乐加糖
 * Date: 13-8-11
 * Time: 下午9:43
 * To change this template use File | Settings | File Templates.
 */

Ext.Loader.setConfig({enabled: true});

Ext.onReady(function(){
    Ext.tip.QuickTipManager.init();
    //创建登陆FORM面板
    var login_panel = Ext.create('Ext.form.Panel', {
        title: '',
        bodyPadding: 5,
        width: 230,
        height:110,
        defaults:{
            xtype: 'textfield',
            labelSeparator:':',
            labelWidth:60
        },
        items:[
            {
                name: 'username',
                fieldLabel: '用户名',
                emptyText:'请输入用户名',
                allowBlank: false
            },{
                name: 'userpass',
                fieldLabel: '密码',
                emptyText:'请输入登陆密码',
                allowBlank: false
            }
        ],
        buttons:[
            {
                text:"确定",
                handler:function(){
                    //我是登陆发送Ajax请求的地方，暂时跳转页面
                    window.location.href = "main.html";
                }
            }
        ]
    });
    var login_window = Ext.create("Ext.window.Window",{
        title:'管理员登陆',
        width:240,
        height:150,
        modal:true,
        resizable:false,
        items:[
            login_panel
        ]
    }).show();
});