/**
 * Created with IntelliJ IDEA.
 * User: 可乐加糖
 * Date: 13-9-16
 * Time: 下午4:24
 * To change this template use File | Settings | File Templates.
 */

var itemsPerPage = 20; //每页显示的条目数
Ext.QuickTips.init();
Ext.Loader.setConfig({enabled: true});

Ext.onReady(function(){

    var user_store = Ext.create('Ext.data.Store',{
        autoLoad:{start:1,limit:itemsPerPage},
        pageSize:itemsPerPage,
        fields:['username','sex','mobile'],
        proxy:{
            type:'ajax',
            url: './data/user.txt',
            reader:{
                type:'json',
                root:'items',
                totalProperty:'result'
            }
        }
    });

    //创建GRID，TOOLS面板
    var toolbar = {
        xtype: 'toolbar',
        dock: 'top',
        padding:'0 0 10 0',
        items: [
            {
                xtype:'button',
                text:'新增用户',
                handler:function(){

                }
            },{
                xtype:'button',
                text:'删除用户',
                handler:function(){

                }
            },'->',
            {
                xtype:'textfield',
                emptyText:'请输入用户名称'
            },{
                xtype:'button',
                value:'搜索',
                handler:function(){

                }
            }
        ]
    }

    var bbar = {
        dock: 'bottom',
        xtype: 'pagingtoolbar',
        store: user_store,
        pageSize: 25,
        displayInfo: true,
        displayMsg: '当前是:{0}-{1}条记录，共计{2}条记录',
        emptyMsg: '暂无数据'
    }

    var grid_panel = {
        title:'',
        dock: 'top',
        store:user_store,
        dockedItems:[
            //顶部工具条
            toolbar,
            //底部分页条
            bbar
        ],
        renderTo:Ext.get("user_list")
    }

});