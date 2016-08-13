/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.opengles;

import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.JNI.*;

/**
 * Native bindings to the <a href="https://www.khronos.org/registry/gles/extensions/EXT/EXT_texture_storage.txt">EXT_texture_storage</a> extension.
 * 
 * <p>The texture image specification commands in OpenGL allow each level to be separately specified with different sizes, formats, types and so on, and only
 * imposes consistency checks at draw time. This adds overhead for implementations.</p>
 * 
 * <p>This extension provides a mechanism for specifying the entire structure of a texture in a single call, allowing certain consistency checks and memory
 * allocations to be done up front. Once specified, the format and dimensions of the image array become immutable, to simplify completeness checks in the
 * implementation.</p>
 * 
 * <p>When using this extension, it is no longer possible to supply texture data using TexImage*. Instead, data can be uploaded using TexSubImage*, or
 * produced by other means (such as render-to-texture, mipmap generation, or rendering to a sibling EGLImage).</p>
 * 
 * <p>This extension has complicated interactions with other extensions. The goal of most of these interactions is to ensure that a texture is always mipmap
 * complete (and cube complete for cubemap textures).</p>
 * 
 * <p>Requires {@link GLES20 GLES 2.0}.</p>
 */
public class EXTTextureStorage {

	/** Accepted by the {@code value} parameter of GetTexParameter{if}v. */
	public static final int GL_TEXTURE_IMMUTABLE_FORMAT_EXT = 0x912F;

	/** Accepted by the {@code internalformat} parameter of TexStorage when implemented on OpenGL ES. */
	public static final int
		GL_ALPHA8_EXT             = 0x803C,
		GL_LUMINANCE8_EXT         = 0x8040,
		GL_LUMINANCE8_ALPHA8_EXT  = 0x8045,
		GL_RGBA32F_EXT            = 0x8814,
		GL_RGB32F_EXT             = 0x8815,
		GL_ALPHA32F_EXT           = 0x8816,
		GL_LUMINANCE32F_EXT       = 0x8818,
		GL_LUMINANCE_ALPHA32F_EXT = 0x8819,
		GL_RGBA16F_EXT            = 0x881A,
		GL_RGB16F_EXT             = 0x881B,
		GL_ALPHA16F_EXT           = 0x881C,
		GL_LUMINANCE16F_EXT       = 0x881E,
		GL_LUMINANCE_ALPHA16F_EXT = 0x881F,
		GL_RGB10_A2_EXT           = 0x8059,
		GL_RGB10_EXT              = 0x8052,
		GL_BGRA8_EXT              = 0x93A1,
		GL_R8_EXT                 = 0x8229,
		GL_RG8_EXT                = 0x822B,
		GL_R32F_EXT               = 0x822E,
		GL_RG32F_EXT              = 0x8230,
		GL_R16F_EXT               = 0x822D,
		GL_RG16F_EXT              = 0x822F,
		GL_RGB_RAW_422_APPLE      = 0x8A51;

	protected EXTTextureStorage() {
		throw new UnsupportedOperationException();
	}

	static boolean isAvailable(GLESCapabilities caps) {
		return checkFunctions(
			caps.glTexStorage1DEXT, caps.glTexStorage2DEXT, caps.glTexStorage3DEXT, caps.glTextureStorage1DEXT, caps.glTextureStorage2DEXT, 
			caps.glTextureStorage3DEXT
		);
	}

	// --- [ glTexStorage1DEXT ] ---

	public static void glTexStorage1DEXT(int target, int levels, int internalformat, int width) {
		long __functionAddress = GLES.getCapabilities().glTexStorage1DEXT;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callV(__functionAddress, target, levels, internalformat, width);
	}

	// --- [ glTexStorage2DEXT ] ---

	public static void glTexStorage2DEXT(int target, int levels, int internalformat, int width, int height) {
		long __functionAddress = GLES.getCapabilities().glTexStorage2DEXT;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callV(__functionAddress, target, levels, internalformat, width, height);
	}

	// --- [ glTexStorage3DEXT ] ---

	public static void glTexStorage3DEXT(int target, int levels, int internalformat, int width, int height, int depth) {
		long __functionAddress = GLES.getCapabilities().glTexStorage3DEXT;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callV(__functionAddress, target, levels, internalformat, width, height, depth);
	}

	// --- [ glTextureStorage1DEXT ] ---

	public static void glTextureStorage1DEXT(int texture, int target, int levels, int internalformat, int width) {
		long __functionAddress = GLES.getCapabilities().glTextureStorage1DEXT;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callV(__functionAddress, texture, target, levels, internalformat, width);
	}

	// --- [ glTextureStorage2DEXT ] ---

	public static void glTextureStorage2DEXT(int texture, int target, int levels, int internalformat, int width, int height) {
		long __functionAddress = GLES.getCapabilities().glTextureStorage2DEXT;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callV(__functionAddress, texture, target, levels, internalformat, width, height);
	}

	// --- [ glTextureStorage3DEXT ] ---

	public static void glTextureStorage3DEXT(int texture, int target, int levels, int internalformat, int width, int height, int depth) {
		long __functionAddress = GLES.getCapabilities().glTextureStorage3DEXT;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callV(__functionAddress, texture, target, levels, internalformat, width, height, depth);
	}

}