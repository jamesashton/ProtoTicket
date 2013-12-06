/*
 * File: app/view/ProfileView.js
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

Ext.define('MyApp.view.ProfileView', {
    extend: 'Ext.Panel',
    alias: 'widget.profileview',

    config: {
        items: [
            {
                xtype: 'navigationview',
                navigationBar: {
                    docked: 'top',
                    items: [
                        {
                            xtype: 'button',
                            ui: 'confirm',
                            text: 'Save'
                        },
                        {
                            xtype: 'segmentedbutton',
                            align: 'right',
                            items: [
                                {
                                    xtype: 'button',
                                    text: 'Profile'
                                },
                                {
                                    xtype: 'button',
                                    text: 'Billing'
                                }
                            ]
                        },
                        {
                            xtype: 'button',
                            ui: 'decline',
                            text: 'Cancel'
                        }
                    ]
                }
            }
        ]
    }

});