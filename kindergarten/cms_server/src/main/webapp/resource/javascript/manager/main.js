/**
 * Created with JetBrains WebStorm.
 * User: 可乐加糖
 * Date: 13-8-11
 * Time: 下午10:06
 * To change this template use File | Settings | File Templates.
 */

Ext.QuickTips.init();
Ext.Loader.setConfig({enabled: true});

Ext.Loader.setPath('tt.plugin', '../javascript/manager/plugin');

Ext.require([
    'tt.plugin.weiXin',
    'tt.plugin.article'
]);

Ext.onReady(function(){
    //定义左侧树形功能导航
    var sys_store = Ext.create('Ext.data.TreeStore', {
        autoLoad :true,
        root: {
            expanded: true,
            text: "系统管理"
        },
        proxy: {
            type: 'ajax',
            url: '../data/tree.txt'
        },
        folderSort: true
    });

    var article_store = Ext.create('Ext.data.TreeStore', {
        root: {
            expanded: true,
            children: [
                { text: "文章管理", leaf: true },
                { text: "栏目管理", leaf: true },
                { text: "微信平台", leaf: true }
            ]
        }
    });

    var nav_panel = Ext.create("Ext.panel.Panel",{
        width: 180,
        layout: {type: 'accordion'},
        title: '',
        items:[
            {
                xtype:'panel',
                title:'系统设置',
                items: [
                    {
                        xtype: 'treepanel',
                        title: '',
                        border:0,
                        bodyBorder:false,
                        store: sys_store,
                        rootVisible: false,
                        listeners:{

                        }
                    }
                ]
            },{
                xtype:'panel',
                title:'文章系统',
                items: [
                    {
                        xtype: 'treepanel',
                        title: '',
                        store: article_store,
                        border:0,
                        bodyBorder:false,
                        rootVisible: false,
                        listeners : {
                            'itemclick' : function(view,re){
                                var nodeName = re.data.text;
                                switch(nodeName){
                                    case '微信平台':
                                        var article_panel = new tt.plugin.weiXin().show();
                                        break;
                                    default :
                                        //弹出创建文章的面板（暂时试试）
                                        var article_panel = new tt.plugin.article({
                                            url:'http://www.baidu.com/'
                                        }).show();
                                }
                            }
                        }
                    }
                ]
            },{
                xtype:'panel',
                border:0,
                bodyBorder:false,
                title:'用户系统'
            },{
                xtype:'panel',
                border:0,
                bodyBorder:false,
                title:'权限系统'
            }
        ]
    });
    //定义ViewPort
    Ext.create('Ext.container.Viewport', {
        layout: 'border',
        items: [{
            region: 'north',
            xtype:'container',
            height:30,
            html: '<div class="manager_title"><h1> CMS 信息发布系统</h1></div>',
            border: false,
            margins: '0 0 3 0'
        }, {
            region: 'west',
            collapsible: true,
            split: true,
            title: '功能导航',
            width: 180,
            maxWidth:300,
            layout:'fit',
            items:[nav_panel]
        }, {
            region: 'south',
            xtype:'container',
            title: '',
            collapsible: false,
            html: '<p class="copyright">拓维信息股份有限公司</p>',
            split: false,
            height:5
        }, {
            region: 'center',
            xtype: 'tabpanel', // TabPanel itself has no title
            activeTab: 0,      // First tab active by default
            items: {
                title: '系统信息',
                html: 'The first tab\'s content. Others may be added dynamically'
            }
        }]
    });
});