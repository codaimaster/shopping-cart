package com.sky.assignments.shoppingcart.model;

public abstract class AbstractPromotion implements Promotion {

	private ItemCriteria criteria;

	public AbstractPromotion(ItemCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public boolean appliesTo(Product item) {
		if (criteria == null)
			return true;
		if (criteria.getNameValue() != null && !item.getName().equals(criteria.getNameValue()))
			return false;
		if (criteria.getTypeValue() != null && !item.getType().equals(criteria.getTypeValue()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((criteria == null) ? 0 : criteria.hashCode());
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
		AbstractPromotion other = (AbstractPromotion) obj;
		if (criteria == null) {
			if (other.criteria != null)
				return false;
		} else if (!criteria.equals(other.criteria))
			return false;
		return true;
	}

}
