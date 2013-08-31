/**
 * Created with JetBrains WebStorm.
 * User: 可乐加糖
 * Date: 13-8-20
 * Time: 下午10:31
 * To change this template use File | Settings | File Templates.
 */

Ext.define('tt.plugin.weixin', {
    extend: 'Ext.window.Window',
    height: 400,
    width: 840,
    modal: true,
    layout: {
        type: 'border'
    },
    padding:10,
    title: '微信公众平台',
    initComponent: function() {
        var me = this;
        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    region: 'west',
                    id: 'info_write',
                    width: 405,
                    title: '',
                    bodyBorder:false,
                    border:0,
                    items: [
                        {
                            xtype: 'textfield',
                            fieldLabel: '标题',
                            labelWidth: 50
                        },
                        {
                            xtype: 'filefield',
                            fieldLabel: '封面',
                            labelWidth: 50
                        },
                        {
                            xtype: 'htmleditor',
                            height: 150,
                            fieldLabel: '内容',
                            labelWidth: 50
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    region: 'center',
                    id: 'right_view',
                    title: ''
                }
            ]
        });
        me.callParent(arguments);
    }
});