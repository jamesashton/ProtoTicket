/*
 * File: app/view/HomeView.js
 *
 * This file was generated by Sencha Architect version 3.0.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Sencha Touch 2.3.x library, under independent license.
 * License of Sencha Architect does not include license for Sencha Touch 2.3.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('app.view.HomeView', {
    extend: 'Ext.Panel',
    alias: 'widget.homeview',

    config: {
        itemId: 'mypanel5',
        layout: {
            type: 'vbox'
        },
        items: [
            {
                xtype: 'navigationview',
                bottom: 0,
                left: 0,
                right: 0,
                top: 0,
                navigationBar: {
                    docked: 'top',
                    left: 0,
                    right: 0,
                    width: '100%',
                    items: [
                        {
                            xtype: 'button',
                            ui: 'plain',
                            iconAlign: 'center',
                            iconCls: 'favorites',
                            text: ''
                        },
                        {
                            xtype: 'spacer',
                            minWidth: '',
                            width: 40
                        },
                        {
                            xtype: 'spacer',
                            flex: 0.5,
                            maxWidth: '',
                            width: 40
                        },
                        {
                            xtype: 'button',
                            align: 'right',
                            ui: 'plain',
                            iconCls: 'time',
                            text: ''
                        }
                    ]
                },
                items: [
                    {
                        xtype: 'container',
                        items: [
                            {
                                xtype: 'spacer',
                                height: 60
                            }
                        ]
                    }
                ]
            }
        ],
        listeners: [
            {
                fn: 'homeViewInitialize',
                event: 'onHomeViewInitialize'
            }
        ]
    },

    homeViewInitialize: function(panel) {
        //alert('about to initialize home view');
        //me.fireEvent('onHomeInitialize', me, username, password);
    }

});