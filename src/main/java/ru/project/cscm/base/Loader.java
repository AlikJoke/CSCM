package ru.project.cscm.base;

import java.util.Collection;

public interface Loader<T> {

	Collection<T> load();
}
