package com.sky.assignments.shoppingcart.model;

import java.math.BigDecimal;

public class MForNPromotion extends AbstractPromotion {

	private int buy;
	private int pay;

	public MForNPromotion(ItemCriteria criteria, int buy, int pay) {
		super(criteria);
		this.buy = buy;
		this.pay = pay;
	}

	@Override
	public BigDecimal charge(Product item, int count) {
		int timesDiscountApplied = count / buy;
		if (appliesTo(item))
			return item.getPrice().multiply(new BigDecimal(timesDiscountApplied * pay + count % buy));
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + buy;
		result = prime * result + pay;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MForNPromotion other = (MForNPromotion) obj;
		if (buy != other.buy)
			return false;
		if (pay != other.pay)
			return false;
		return true;
	}

}
