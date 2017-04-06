package br.com.lists;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
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
@Generated({"Immutables.generator", "ListTemplate"})
public final class List implements ListTemplate {
  private final UUID uuid;
  private final String name;

  private List(List.Builder builder) {
    this.name = builder.name;
    this.uuid = builder.uuid != null
        ? builder.uuid
        : Objects.requireNonNull(ListTemplate.super.uuid(), "uuid");
  }

  private List(UUID uuid, String name) {
    this.uuid = uuid;
    this.name = name;
  }

  /**
   * @return The value of the {@code uuid} attribute
   */
  @JsonProperty("uuid")
  @Override
  public UUID uuid() {
    return uuid;
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
   * Copy the current immutable object by setting a value for the {@link ListTemplate#uuid() uuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uuid
   * @return A modified copy of the {@code this} object
   */
  public final List withUuid(UUID value) {
    if (this.uuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "uuid");
    return new List(newValue, this.name);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ListTemplate#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final List withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new List(this.uuid, newValue);
  }

  /**
   * This instance is equal to all instances of {@code List} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof List
        && equalTo((List) another);
  }

  private boolean equalTo(List another) {
    return uuid.equals(another.uuid)
        && name.equals(another.name);
  }

  /**
   * Computes a hash code from attributes: {@code uuid}, {@code name}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + uuid.hashCode();
    h = h * 17 + name.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code List} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "List{"
        + "uuid=" + uuid
        + ", name=" + name
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements ListTemplate {
    UUID uuid;
    String name;
    @JsonProperty("uuid")
    public void setUuid(UUID uuid) {
      this.uuid = uuid;
    }
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @Override
    public UUID uuid() { throw new UnsupportedOperationException(); }
    @Override
    public String name() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static List fromJson(Json json) {
    List.Builder builder = List.builder();
    if (json.uuid != null) {
      builder.uuid(json.uuid);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ListTemplate} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable List instance
   */
  public static List copyOf(ListTemplate instance) {
    if (instance instanceof List) {
      return (List) instance;
    }
    return List.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link List List}.
   * @return A new List builder
   */
  public static List.Builder builder() {
    return new List.Builder();
  }

  /**
   * Builds instances of type {@link List List}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private long initBits = 0x1L;

    private UUID uuid;
    private String name;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ListTemplate} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ListTemplate instance) {
      Objects.requireNonNull(instance, "instance");
      uuid(instance.uuid());
      name(instance.name());
      return this;
    }

    /**
     * Initializes the value for the {@link ListTemplate#uuid() uuid} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link ListTemplate#uuid() uuid}.</em>
     * @param uuid The value for uuid 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("uuid")
    public final Builder uuid(UUID uuid) {
      this.uuid = Objects.requireNonNull(uuid, "uuid");
      return this;
    }

    /**
     * Initializes the value for the {@link ListTemplate#name() name} attribute.
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
     * Builds a new {@link List List}.
     * @return An immutable instance of List
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public List build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new List(this);
    }

    private String formatRequiredAttributesMessage() {
      java.util.List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      return "Cannot build List, some of required attributes are not set " + attributes;
    }
  }
}
