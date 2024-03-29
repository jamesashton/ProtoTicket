/*
 * File: app/controller/HomeController.js
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

Ext.define('app.controller.HomeController', {
    extend: 'Ext.app.Controller',

    config: {
        models: [
            'LoginStatus'
        ],
        views: [
            'HomeView',
            'ProfileView'
        ],

        refs: {
            homeView: 'homeview',
            profileView: {
                autoCreate: true,
                forceCreate: true,
                selector: 'profileview',
                xtype: 'profileview'
            }
        },

        control: {
            "homeview": {
                initialize: 'onHomeInitialize'
            }
        }
    },

    onHomeInitialize: function(component, eOpts) {

        //alert('username:' + Myapp.loginstatus.username);
        //var profileView = this.getProfileView();
        //profileView.setUsername(Myapp.loginstatus.username);
        console.log("StoreLoaded?");
        debugger;
    }

});