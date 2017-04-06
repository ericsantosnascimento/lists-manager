package br.com.lists;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Generated;

/**
 * This is just a template, the concrete class will be generated at compile time,
 * <p> to more info reefer to -> http://immutables.github.io is a open source project, the lib main benefit is provide is implementations to use immutability and avoid boiler plate code </p>
 * <p>
 * Created by eric-nasc on 05/04/17.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ItemTemplate"})
public final class Item implements ItemTemplate {
  private final UUID uuid;
  private final String name;
  private final boolean isMarkedAsCheck;
  private final Integer quantity;

  private Item(Item.Builder builder) {
    this.name = builder.name;
    this.quantity = builder.quantity;
    if (builder.uuid != null) {
      initShim.uuid(builder.uuid);
    }
    if (builder.isMarkedAsCheckIsSet()) {
      initShim.isMarkedAsCheck(builder.isMarkedAsCheck);
    }
    this.uuid = initShim.uuid();
    this.isMarkedAsCheck = initShim.isMarkedAsCheck();
    this.initShim = null;
  }

  private Item(UUID uuid, String name, boolean isMarkedAsCheck, Integer quantity) {
    this.uuid = uuid;
    this.name = name;
    this.isMarkedAsCheck = isMarkedAsCheck;
    this.quantity = quantity;
    this.initShim = null;
  }

  private static final int STAGE_INITIALIZING = -1;
  private static final int STAGE_UNINITIALIZED = 0;
  private static final int STAGE_INITIALIZED = 1;
  private transient volatile InitShim initShim = new InitShim();

  private final class InitShim {
    private UUID uuid;
    private int uuidBuildStage;

    UUID uuid() {
      if (uuidBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (uuidBuildStage == STAGE_UNINITIALIZED) {
        uuidBuildStage = STAGE_INITIALIZING;
        this.uuid = Objects.requireNonNull(uuidInitialize(), "uuid");
        uuidBuildStage = STAGE_INITIALIZED;
      }
      return this.uuid;
    }

    void uuid(UUID uuid) {
      this.uuid = uuid;
      uuidBuildStage = STAGE_INITIALIZED;
    }
    private boolean isMarkedAsCheck;
    private int isMarkedAsCheckBuildStage;

    boolean isMarkedAsCheck() {
      if (isMarkedAsCheckBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (isMarkedAsCheckBuildStage == STAGE_UNINITIALIZED) {
        isMarkedAsCheckBuildStage = STAGE_INITIALIZING;
        this.isMarkedAsCheck = isMarkedAsCheckInitialize();
        isMarkedAsCheckBuildStage = STAGE_INITIALIZED;
      }
      return this.isMarkedAsCheck;
    }

    void isMarkedAsCheck(boolean isMarkedAsCheck) {
      this.isMarkedAsCheck = isMarkedAsCheck;
      isMarkedAsCheckBuildStage = STAGE_INITIALIZED;
    }

    private String formatInitCycleMessage() {
      ArrayList<String> attributes = new ArrayList<String>();
      if (uuidBuildStage == STAGE_INITIALIZING) attributes.add("uuid");
      if (isMarkedAsCheckBuildStage == STAGE_INITIALIZING) attributes.add("isMarkedAsCheck");
      return "Cannot build Item, attribute initializers form cycle" + attributes;
    }
  }

  private UUID uuidInitialize() {
    return ItemTemplate.super.uuid();
  }

  private boolean isMarkedAsCheckInitialize() {
    return ItemTemplate.super.isMarkedAsCheck();
  }

  /**
   * @return The value of the {@code uuid} attribute
   */
  @JsonProperty("uuid")
  @Override
  public UUID uuid() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.uuid()
        : this.uuid;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String name() {
    return name;
  }

  /**
   * @return The value of the {@code isMarkedAsCheck} attribute
   */
  @JsonProperty("isMarkedAsCheck")
  @Override
  public boolean isMarkedAsCheck() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.isMarkedAsCheck()
        : this.isMarkedAsCheck;
  }

  /**
   * @return The value of the {@code quantity} attribute
   */
  @JsonProperty("quantity")
  @Override
  public Integer quantity() {
    return quantity;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItemTemplate#uuid() uuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uuid
   * @return A modified copy of the {@code this} object
   */
  public final Item withUuid(UUID value) {
    if (this.uuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "uuid");
    return new Item(newValue, this.name, this.isMarkedAsCheck, this.quantity);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItemTemplate#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final Item withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new Item(this.uuid, newValue, this.isMarkedAsCheck, this.quantity);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItemTemplate#isMarkedAsCheck() isMarkedAsCheck} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for isMarkedAsCheck
   * @return A modified copy of the {@code this} object
   */
  public final Item withIsMarkedAsCheck(boolean value) {
    if (this.isMarkedAsCheck == value) return this;
    return new Item(this.uuid, this.name, value, this.quantity);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItemTemplate#quantity() quantity} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for quantity
   * @return A modified copy of the {@code this} object
   */
  public final Item withQuantity(Integer value) {
    if (this.quantity.equals(value)) return this;
    Integer newValue = Objects.requireNonNull(value, "quantity");
    return new Item(this.uuid, this.name, this.isMarkedAsCheck, newValue);
  }

  /**
   * This instance is equal to all instances of {@code Item} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof Item
        && equalTo((Item) another);
  }

  private boolean equalTo(Item another) {
    return uuid.equals(another.uuid)
        && name.equals(another.name)
        && isMarkedAsCheck == another.isMarkedAsCheck
        && quantity.equals(another.quantity);
  }

  /**
   * Computes a hash code from attributes: {@code uuid}, {@code name}, {@code isMarkedAsCheck}, {@code quantity}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + uuid.hashCode();
    h = h * 17 + name.hashCode();
    h = h * 17 + Boolean.hashCode(isMarkedAsCheck);
    h = h * 17 + quantity.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Item} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Item{"
        + "uuid=" + uuid
        + ", name=" + name
        + ", isMarkedAsCheck=" + isMarkedAsCheck
        + ", quantity=" + quantity
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements ItemTemplate {
    UUID uuid;
    String name;
    boolean isMarkedAsCheck;
    boolean isMarkedAsCheckIsSet;
    Integer quantity;
    @JsonProperty("uuid")
    public void setUuid(UUID uuid) {
      this.uuid = uuid;
    }
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("isMarkedAsCheck")
    public void setIsMarkedAsCheck(boolean isMarkedAsCheck) {
      this.isMarkedAsCheck = isMarkedAsCheck;
      this.isMarkedAsCheckIsSet = true;
    }
    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
      this.quantity = quantity;
    }
    @Override
    public UUID uuid() { throw new UnsupportedOperationException(); }
    @Override
    public String name() { throw new UnsupportedOperationException(); }
    @Override
    public boolean isMarkedAsCheck() { throw new UnsupportedOperationException(); }
    @Override
    public Integer quantity() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static Item fromJson(Json json) {
    Item.Builder builder = Item.builder();
    if (json.uuid != null) {
      builder.uuid(json.uuid);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.isMarkedAsCheckIsSet) {
      builder.isMarkedAsCheck(json.isMarkedAsCheck);
    }
    if (json.quantity != null) {
      builder.quantity(json.quantity);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ItemTemplate} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Item instance
   */
  public static Item copyOf(ItemTemplate instance) {
    if (instance instanceof Item) {
      return (Item) instance;
    }
    return Item.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link Item Item}.
   * @return A new Item builder
   */
  public static Item.Builder builder() {
    return new Item.Builder();
  }

  /**
   * Builds instances of type {@link Item Item}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_QUANTITY = 0x2L;
    private static final long OPT_BIT_IS_MARKED_AS_CHECK = 0x1L;
    private long initBits = 0x3L;
    private long optBits;

    private UUID uuid;
    private String name;
    private boolean isMarkedAsCheck;
    private Integer quantity;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ItemTemplate} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ItemTemplate instance) {
      Objects.requireNonNull(instance, "instance");
      uuid(instance.uuid());
      name(instance.name());
      isMarkedAsCheck(instance.isMarkedAsCheck());
      quantity(instance.quantity());
      return this;
    }

    /**
     * Initializes the value for the {@link ItemTemplate#uuid() uuid} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link ItemTemplate#uuid() uuid}.</em>
     * @param uuid The value for uuid 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("uuid")
    public final Builder uuid(UUID uuid) {
      this.uuid = Objects.requireNonNull(uuid, "uuid");
      return this;
    }

    /**
     * Initializes the value for the {@link ItemTemplate#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("name")
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link ItemTemplate#isMarkedAsCheck() isMarkedAsCheck} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link ItemTemplate#isMarkedAsCheck() isMarkedAsCheck}.</em>
     * @param isMarkedAsCheck The value for isMarkedAsCheck 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("isMarkedAsCheck")
    public final Builder isMarkedAsCheck(boolean isMarkedAsCheck) {
      this.isMarkedAsCheck = isMarkedAsCheck;
      optBits |= OPT_BIT_IS_MARKED_AS_CHECK;
      return this;
    }

    /**
     * Initializes the value for the {@link ItemTemplate#quantity() quantity} attribute.
     * @param quantity The value for quantity 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("quantity")
    public final Builder quantity(Integer quantity) {
      this.quantity = Objects.requireNonNull(quantity, "quantity");
      initBits &= ~INIT_BIT_QUANTITY;
      return this;
    }

    /**
     * Builds a new {@link Item Item}.
     * @return An immutable instance of Item
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Item build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new Item(this);
    }

    private boolean isMarkedAsCheckIsSet() {
      return (optBits & OPT_BIT_IS_MARKED_AS_CHECK) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_QUANTITY) != 0) attributes.add("quantity");
      return "Cannot build Item, some of required attributes are not set " + attributes;
    }
  }
}
