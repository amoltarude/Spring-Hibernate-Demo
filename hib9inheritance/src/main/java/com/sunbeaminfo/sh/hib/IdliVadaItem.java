package com.sunbeaminfo.sh.hib;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Idli Vada")
public class IdliVadaItem extends Item {
	private static final long serialVersionUID = 1L;
	// ...
}
