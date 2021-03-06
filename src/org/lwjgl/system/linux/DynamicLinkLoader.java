/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.system.linux;

import java.nio.*;

import org.lwjgl.system.*;

import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

/** Native bindings to <dlfcn.h>. */
public class DynamicLinkLoader {

	/** The {@code mode} argument to {@link #dlopen} contains one of the following. */
	public static final int
		RTLD_LAZY         = 0x1,
		RTLD_NOW          = 0x2,
		RTLD_BINDING_MASK = 0x3,
		RTLD_NOLOAD       = 0x4,
		RTLD_DEEPBIND     = 0x8;

	/**
	 * If the following bit is set in the {@code mode} argument to {@link #dlopen}, the symbols of the loaded object and its dependencies are made visible as
	 * if the object were linked directly into the program.
	 */
	public static final int RTLD_GLOBAL = 0x100;

	/**
	 * Unix98 demands the following flag which is the inverse to {@link #RTLD_GLOBAL}. The implementation does this by default and so we can define the value
	 * to zero.
	 */
	public static final int RTLD_LOCAL = 0;

	/** Do not delete object when closed. */
	public static final int RTLD_NODELETE = 0x1000;

	static { Library.initialize(); }

	protected DynamicLinkLoader() {
		throw new UnsupportedOperationException();
	}

	// --- [ dlopen ] ---

	/**
	 * Loads the dynamic library file named by the null-terminated string {@code filename} and returns an opaque "handle" for the dynamic library. If
	 * {@code filename} is {@code NULL}, then the returned handle is for the main program.
	 *
	 * @param filename the name of the dynamic library to open, or {@code NULL}
	 * @param mode     a bitfield. One or more of:<br><table><tr><td>{@link #RTLD_LAZY}</td><td>{@link #RTLD_NOW}</td><td>{@link #RTLD_BINDING_MASK}</td><td>{@link #RTLD_NOLOAD}</td><td>{@link #RTLD_DEEPBIND}</td><td>{@link #RTLD_GLOBAL}</td></tr><tr><td>{@link #RTLD_LOCAL}</td><td>{@link #RTLD_NODELETE}</td></tr></table>
	 */
	public static native long ndlopen(long filename, int mode);

	/**
	 * Loads the dynamic library file named by the null-terminated string {@code filename} and returns an opaque "handle" for the dynamic library. If
	 * {@code filename} is {@code NULL}, then the returned handle is for the main program.
	 *
	 * @param filename the name of the dynamic library to open, or {@code NULL}
	 * @param mode     a bitfield. One or more of:<br><table><tr><td>{@link #RTLD_LAZY}</td><td>{@link #RTLD_NOW}</td><td>{@link #RTLD_BINDING_MASK}</td><td>{@link #RTLD_NOLOAD}</td><td>{@link #RTLD_DEEPBIND}</td><td>{@link #RTLD_GLOBAL}</td></tr><tr><td>{@link #RTLD_LOCAL}</td><td>{@link #RTLD_NODELETE}</td></tr></table>
	 */
	public static long dlopen(ByteBuffer filename, int mode) {
		if ( CHECKS )
			if ( filename != null ) checkNT1(filename);
		return ndlopen(memAddressSafe(filename), mode);
	}

	/**
	 * Loads the dynamic library file named by the null-terminated string {@code filename} and returns an opaque "handle" for the dynamic library. If
	 * {@code filename} is {@code NULL}, then the returned handle is for the main program.
	 *
	 * @param filename the name of the dynamic library to open, or {@code NULL}
	 * @param mode     a bitfield. One or more of:<br><table><tr><td>{@link #RTLD_LAZY}</td><td>{@link #RTLD_NOW}</td><td>{@link #RTLD_BINDING_MASK}</td><td>{@link #RTLD_NOLOAD}</td><td>{@link #RTLD_DEEPBIND}</td><td>{@link #RTLD_GLOBAL}</td></tr><tr><td>{@link #RTLD_LOCAL}</td><td>{@link #RTLD_NODELETE}</td></tr></table>
	 */
	public static long dlopen(CharSequence filename, int mode) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			ByteBuffer filenameEncoded = stack.ASCII(filename);
			return ndlopen(memAddressSafe(filenameEncoded), mode);
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ dlerror ] ---

	/**
	 * Returns a human readable string describing the most recent error that occurred from {@link #dlopen}, {@link #dlsym} or {@link #dlclose} since
	 * the last call to {@code dlerror()}. It returns {@code NULL} if no errors have occurred since initialization or since it was last called.
	 */
	public static native long ndlerror();

	/**
	 * Returns a human readable string describing the most recent error that occurred from {@link #dlopen}, {@link #dlsym} or {@link #dlclose} since
	 * the last call to {@code dlerror()}. It returns {@code NULL} if no errors have occurred since initialization or since it was last called.
	 */
	public static String dlerror() {
		long __result = ndlerror();
		return memASCII(__result);
	}

	// --- [ dlsym ] ---

	/**
	 * Takes a "handle" of a dynamic library returned by {@link #dlopen} and the null-terminated symbol name, returning the address where that symbol is loaded
	 * into memory. If the symbol is not found, in the specified library or any of the libraries that were automatically loaded by {@link #dlopen} when that
	 * library was loaded, {@code dlsym()} returns {@code NULL}.
	 *
	 * @param handle the dynamic library handle
	 * @param name   the symbol name
	 */
	public static native long ndlsym(long handle, long name);

	/**
	 * Takes a "handle" of a dynamic library returned by {@link #dlopen} and the null-terminated symbol name, returning the address where that symbol is loaded
	 * into memory. If the symbol is not found, in the specified library or any of the libraries that were automatically loaded by {@link #dlopen} when that
	 * library was loaded, {@code dlsym()} returns {@code NULL}.
	 *
	 * @param handle the dynamic library handle
	 * @param name   the symbol name
	 */
	public static long dlsym(long handle, ByteBuffer name) {
		if ( CHECKS ) {
			checkPointer(handle);
			checkNT1(name);
		}
		return ndlsym(handle, memAddress(name));
	}

	/**
	 * Takes a "handle" of a dynamic library returned by {@link #dlopen} and the null-terminated symbol name, returning the address where that symbol is loaded
	 * into memory. If the symbol is not found, in the specified library or any of the libraries that were automatically loaded by {@link #dlopen} when that
	 * library was loaded, {@code dlsym()} returns {@code NULL}.
	 *
	 * @param handle the dynamic library handle
	 * @param name   the symbol name
	 */
	public static long dlsym(long handle, CharSequence name) {
		if ( CHECKS )
			checkPointer(handle);
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			ByteBuffer nameEncoded = stack.ASCII(name);
			return ndlsym(handle, memAddress(nameEncoded));
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ dlclose ] ---

	/**
	 * Decrements the reference count on the dynamic library handle handle. If the reference count drops to zero and no other loaded libraries use symbols in
	 * it, then the dynamic library is unloaded.
	 *
	 * @param handle the dynamic library to close
	 */
	public static native int ndlclose(long handle);

	/**
	 * Decrements the reference count on the dynamic library handle handle. If the reference count drops to zero and no other loaded libraries use symbols in
	 * it, then the dynamic library is unloaded.
	 *
	 * @param handle the dynamic library to close
	 */
	public static int dlclose(long handle) {
		if ( CHECKS )
			checkPointer(handle);
		return ndlclose(handle);
	}

}