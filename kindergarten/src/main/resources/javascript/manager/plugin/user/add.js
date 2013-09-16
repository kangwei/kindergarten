/**
 * Created with IntelliJ IDEA.
 * User: 可乐加糖
 * Date: 13-9-16
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */

Ext.define('tt.user.add', {
    extend: 'Ext.window.Window',

    draggable: false,
    height: 411,
    width: 553,
    layout: {
        type: 'fit'
    },
    title: '用户信息',
    initComponent: function() {
        var me = this;
        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    bodyPadding: 10,
                    title: '',
                    defaults:{
                        labelSeparator:":",
                        labelWidth:50,
                        width:260
                    },
                    items: [
                        {
                            xtype: 'fieldset',
                            title: '用户信息',
                            items: [
                                {
                                    xtype: 'textfield',
                                    anchor: '100%',
                                    fieldLabel: '用户名'
                                },
                                {
                                    xtype: 'textfield',
                                    anchor: '100%',
                                    fieldLabel: '手机号'
                                }
                            ]
                        }
                    ]
                }
            ]
        });
        me.callParent(arguments);
    }
});