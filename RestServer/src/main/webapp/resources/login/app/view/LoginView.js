/*
 * File: app/view/LoginView.js
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

Ext.define('MyApp.view.LoginView', {
    extend: 'Ext.Container',
    alias: 'widget.loginview',

    config: {
        layout: {
            type: 'vbox'
        },
        items: [
            {
                xtype: 'container',
                centered: true,
                height: '480px',
                width: '100%',
                items: [
                    {
                        xtype: 'formpanel',
                        centered: true,
                        height: '100%',
                        maxWidth: '320px',
                        padding: 10,
                        width: '320px',
                        items: [
                            {
                                xtype: 'image',
                                height: 201,
                                src: './images/loginpic.png'
                            },
                            {
                                xtype: 'spacer',
                                height: '10px'
                            },
                            {
                                xtype: 'label',
                                cls: 'loginHeading',
                                html: 'Please Login.'
                            },
                            {
                                xtype: 'spacer',
                                height: 10
                            },
                            {
                                xtype: 'label',
                                centered: false,
                                cls: 'signInFailedLabel',
                                hidden: true,
                                html: 'Login Failed. Please try again.',
                                itemId: 'signInFailedLabel',
                                style: ''
                            },
                            {
                                xtype: 'spacer',
                                height: '10px'
                            },
                            {
                                xtype: 'textfield',
                                cls: 'fieldLabel',
                                itemId: 'userNameTextField',
                                label: 'Username',
                                labelCls: 'fieldLabel',
                                labelWidth: 100
                            },
                            {
                                xtype: 'spacer',
                                height: 1
                            },
                            {
                                xtype: 'textfield',
                                cls: 'fieldLabel',
                                height: 20,
                                itemId: 'passwordTextField',
                                label: 'Password',
                                labelCls: 'fieldLabel',
                                labelWidth: 100
                            },
                            {
                                xtype: 'spacer',
                                height: 20
                            },
                            {
                                xtype: 'button',
                                cls: 'buttonFont',
                                height: 40,
                                itemId: 'loginButton',
                                margin: '10px',
                                text: 'Login'
                            }
                        ]
                    }
                ]
            }
        ],
        listeners: [
            {
                fn: 'onButtonTap',
                event: 'tap',
                delegate: '#loginButton'
            }
        ]
    },

    onButtonTap: function(button, e, eOpts) {
        debugger;
        var me = this;
        var usernameField = me.down('#userNameTextField');
        var passwordField = me.down('#passwordTextField');
        var label = me.down('#signInFailedLabel');
        label.hide();
        var username = usernameField.getValue();
        var password = passwordField.getValue();
        /*var task = Ext.create('Ext.util.DelayedTask', function ()
        {
            label.setHtml('');
            me.parent.fireEvent('signInCommand', me, username, password);
            usernameField.setValue('');
            passwordField.setValue('');

        });
        task.delay(500);*/
            label.setHtml('');
            me.fireEvent('signInCommand', me, username, password);
            usernameField.setValue('');
            passwordField.setValue('');
    },

    showSignInFailedMessage: function(message) {
        var label = this.down('#signInFailedLabel');
        label.setHtml(message);
        label.show();
    }

});