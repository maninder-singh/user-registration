/**
 * This module is having user related attributes.
 * @author maninders
 * @class User
 * @module UserRegistration
 */

UserRegistrationApp.User = Ember.Object.extend({
	/**
	 * Primary (Unique) key to identify user.
	 * @property userId
	 * @type Integer
	 * @default 0
	 */
    userId : 0,
    /**
     * First Name of User.
     * @property firstName
     * @type String
     * @default 
     */
    firstName : "",
    /**
     * Middle Name of User.
     * @property middleName
     * @type String
     * @default 
     */
    middleName : "",
    /**
     * Last Name of User.
     * @property lastName
     * @type String
     * @default 
     */
    lastName : "",
    /**
     * Address of User.
     * @property address
     * @type String
     * @default 
     */
    address : "",
    /**
     * City of User.
     * @property city
     * @type String
     * @default 
     */
    city : "",
    /**
     * State of user.
     * @property state
     * @type String
     * @default 
     */
    state : "",
    /**
     * Zip of User.
     * @property zip
     * @type String
     * @default 
     */
    zip : "",
    /**
     * Country of User.
     * @property country
     * @type String
     * @default 
     */
    country : "",
    /**
     * Email ID of User.
     * @property email
     * @type String
     * @default 
     */
    email : ""
});