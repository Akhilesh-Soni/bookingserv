
package com.paypal.bfs.test.bookingserv.api.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Booking resource
 * <p>
 * Booking resource object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "first_name",
    "last_name",
    "date_of_birth",
    "checkin_datetime",
    "checkout_datetime",
    "total_price",
    "deposit",
    "address"
})
public class Booking {

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Booking id")
    private Integer id;
    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    @JsonPropertyDescription("First name")
    @Pattern(regexp = "(.|\\s)*\\S(.|\\s)*")
    @Size(min = 1, max = 255)
    @NotNull
    private String firstName;
    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    @JsonPropertyDescription("Last name")
    @Pattern(regexp = "(.|\\s)*\\S(.|\\s)*")
    @Size(min = 1, max = 255)
    @NotNull
    private String lastName;
    /**
     * Date of Birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    @JsonPropertyDescription("Date of Birth")
    @NotNull
    private Date dateOfBirth;
    /**
     * Check IN Time
     * (Required)
     * 
     */
    @JsonProperty("checkin_datetime")
    @JsonPropertyDescription("Check IN Time")
    @NotNull
    private Date checkinDatetime;
    /**
     * Check Out Time
     * (Required)
     * 
     */
    @JsonProperty("checkout_datetime")
    @JsonPropertyDescription("Check Out Time")
    @NotNull
    private Date checkoutDatetime;
    /**
     * Total Price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    @JsonPropertyDescription("Total Price")
    @NotNull
    private Integer totalPrice;
    /**
     * Deposit
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    @JsonPropertyDescription("Deposit")
    @NotNull
    private Integer deposit;
    /**
     * Address 
     * <p>
     * Address object
     * (Required)
     * 
     */
    @JsonProperty("address")
    @JsonPropertyDescription("Address object")
    @Valid
    @NotNull
    private Address address;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Booking() {
    }

    /**
     * 
     * @param firstName
     * @param lastName
     * @param checkinDatetime
     * @param address
     * @param totalPrice
     * @param checkoutDatetime
     * @param deposit
     * @param dateOfBirth
     * @param id
     */
    public Booking(Integer id, String firstName, String lastName, Date dateOfBirth, Date checkinDatetime, Date checkoutDatetime, Integer totalPrice, Integer deposit, Address address) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.checkinDatetime = checkinDatetime;
        this.checkoutDatetime = checkoutDatetime;
        this.totalPrice = totalPrice;
        this.deposit = deposit;
        this.address = address;
    }

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Booking withId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Booking withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Booking withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Date of Birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Date of Birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Booking withDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * Check IN Time
     * (Required)
     * 
     */
    @JsonProperty("checkin_datetime")
    public Date getCheckinDatetime() {
        return checkinDatetime;
    }

    /**
     * Check IN Time
     * (Required)
     * 
     */
    @JsonProperty("checkin_datetime")
    public void setCheckinDatetime(Date checkinDatetime) {
        this.checkinDatetime = checkinDatetime;
    }

    public Booking withCheckinDatetime(Date checkinDatetime) {
        this.checkinDatetime = checkinDatetime;
        return this;
    }

    /**
     * Check Out Time
     * (Required)
     * 
     */
    @JsonProperty("checkout_datetime")
    public Date getCheckoutDatetime() {
        return checkoutDatetime;
    }

    /**
     * Check Out Time
     * (Required)
     * 
     */
    @JsonProperty("checkout_datetime")
    public void setCheckoutDatetime(Date checkoutDatetime) {
        this.checkoutDatetime = checkoutDatetime;
    }

    public Booking withCheckoutDatetime(Date checkoutDatetime) {
        this.checkoutDatetime = checkoutDatetime;
        return this;
    }

    /**
     * Total Price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public Integer getTotalPrice() {
        return totalPrice;
    }

    /**
     * Total Price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Booking withTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    /**
     * Deposit
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public Integer getDeposit() {
        return deposit;
    }

    /**
     * Deposit
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Booking withDeposit(Integer deposit) {
        this.deposit = deposit;
        return this;
    }

    /**
     * Address 
     * <p>
     * Address object
     * (Required)
     * 
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * Address 
     * <p>
     * Address object
     * (Required)
     * 
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    public Booking withAddress(Address address) {
        this.address = address;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Booking withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Booking.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("dateOfBirth");
        sb.append('=');
        sb.append(((this.dateOfBirth == null)?"<null>":this.dateOfBirth));
        sb.append(',');
        sb.append("checkinDatetime");
        sb.append('=');
        sb.append(((this.checkinDatetime == null)?"<null>":this.checkinDatetime));
        sb.append(',');
        sb.append("checkoutDatetime");
        sb.append('=');
        sb.append(((this.checkoutDatetime == null)?"<null>":this.checkoutDatetime));
        sb.append(',');
        sb.append("totalPrice");
        sb.append('=');
        sb.append(((this.totalPrice == null)?"<null>":this.totalPrice));
        sb.append(',');
        sb.append("deposit");
        sb.append('=');
        sb.append(((this.deposit == null)?"<null>":this.deposit));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
