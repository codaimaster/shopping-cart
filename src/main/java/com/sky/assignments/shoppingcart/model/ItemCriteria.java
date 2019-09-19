package com.sky.assignments.shoppingcart.model;

public class ItemCriteria {
	private String nameValue;
	private String typeValue;

	public ItemCriteria(String nameValue, String typeValue) {
		super();
		this.nameValue = nameValue;
		this.typeValue = typeValue;
	}

	public String getNameValue() {
		return nameValue;
	}

	public String getTypeValue() {
		return typeValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameValue == null) ? 0 : nameValue.hashCode());
		result = prime * result + ((typeValue == null) ? 0 : typeValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCriteria other = (ItemCriteria) obj;
		if (nameValue == null) {
			if (other.nameValue != null)
				return false;
		} else if (!nameValue.equals(other.nameValue))
			return false;
		if (typeValue == null) {
			if (other.typeValue != null)
				return false;
		} else if (!typeValue.equals(other.typeValue))
			return false;
		return true;
	}

}
