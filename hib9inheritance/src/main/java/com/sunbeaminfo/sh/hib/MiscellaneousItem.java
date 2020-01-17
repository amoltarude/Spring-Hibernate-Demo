package com.sunbeaminfo.sh.hib;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Miscellaneous")
public class MiscellaneousItem extends Item {
	private static final long serialVersionUID = 1L;
	// ...
}
