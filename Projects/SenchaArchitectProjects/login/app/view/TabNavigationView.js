/*
 * File: app/view/TabNavigationView.js
 *
 * This file was generated by Sencha Architect version 3.0.1.
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

Ext.define('app.view.TabNavigationView', {
    extend: 'Ext.tab.Panel',
    alias: 'widget.tabnavigationview',

    requires: [
        'app.view.HomeView',
        'app.view.BrowseView',
        'app.view.SearchView',
        'app.view.Favourites',
        'app.view.ProfileView',
        'Ext.tab.Bar',
        'Ext.Panel'
    ],

    config: {
        tabBar: {
            docked: 'bottom',
            layout: {
                type: 'hbox',
                align: 'center',
                pack: 'center'
            }
        },
        items: [
            {
                xtype: 'homeview',
                itemId: 'HomeView',
                title: 'Home',
                iconCls: 'home'
            },
            {
                xtype: 'browseview',
                title: 'Browse',
                iconCls: 'arrow_right'
            },
            {
                xtype: 'searchview',
                title: 'Search',
                iconCls: 'search'
            },
            {
                xtype: 'favourites',
                title: 'Favourites',
                iconCls: 'favorites'
            },
            {
                xtype: 'profileview',
                title: 'Profile',
                iconCls: 'user'
            }
        ]
    }

});