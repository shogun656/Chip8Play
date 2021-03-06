/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.opengl;

import java.nio.*;

import org.lwjgl.*;

import org.lwjgl.system.*;

import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.JNI.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * The core OpenGL 3.1 functionality. OpenGL 3.1 implementations support revision 1.40 of the OpenGL Shading Language.
 * 
 * <p>Extensions promoted to core in this release:</p>
 * 
 * <ul>
 * <li><a href="http://www.opengl.org/registry/specs/ARB/draw_instanced.txt">ARB_draw_instanced</a></li>
 * <li><a href="http://www.opengl.org/registry/specs/ARB/copy_buffer.txt">ARB_copy_buffer</a></li>
 * <li><a href="http://www.opengl.org/registry/specs/NV/primitive_restart.txt">NV_primitive_restart</a></li>
 * <li><a href="http://www.opengl.org/registry/specs/ARB/texture_buffer_object.txt">ARB_texture_buffer_object</a></li>
 * <li><a href="http://www.opengl.org/registry/specs/ARB/texture_rectangle.txt">ARB_texture_rectangle</a></li>
 * <li><a href="http://www.opengl.org/registry/specs/ARB/uniform_buffer_object.txt">ARB_uniform_buffer_object</a></li>
 * </ul>
 */
public class GL31 {

	/** Accepted by the {@code internalFormat} parameter of TexImage1D, TexImage2D, and TexImage3D. */
	public static final int
		GL_R8_SNORM     = 0x8F94,
		GL_RG8_SNORM    = 0x8F95,
		GL_RGB8_SNORM   = 0x8F96,
		GL_RGBA8_SNORM  = 0x8F97,
		GL_R16_SNORM    = 0x8F98,
		GL_RG16_SNORM   = 0x8F99,
		GL_RGB16_SNORM  = 0x8F9A,
		GL_RGBA16_SNORM = 0x8F9B;

	/** Returned by GetTexLevelParameter and GetFramebufferAttachmentParameter. */
	public static final int GL_SIGNED_NORMALIZED = 0x8F9C;

	/** Returned by the {@code type} parameter of GetActiveUniform. */
	public static final int
		GL_SAMPLER_BUFFER               = 0x8DC2,
		GL_INT_SAMPLER_2D_RECT          = 0x8DCD,
		GL_INT_SAMPLER_BUFFER           = 0x8DD0,
		GL_UNSIGNED_INT_SAMPLER_2D_RECT = 0x8DD5,
		GL_UNSIGNED_INT_SAMPLER_BUFFER  = 0x8DD8;

	/**
	 * Accepted by the target parameters of BindBuffer, BufferData, BufferSubData, MapBuffer, UnmapBuffer, GetBufferSubData, GetBufferPointerv, MapBufferRange,
	 * FlushMappedBufferRange, GetBufferParameteriv, BindBufferRange, BindBufferBase, and CopyBufferSubData.
	 */
	public static final int
		GL_COPY_READ_BUFFER  = 0x8F36,
		GL_COPY_WRITE_BUFFER = 0x8F37;

	/** Accepted by the {@code cap} parameter of Enable, Disable and IsEnabled. */
	public static final int GL_PRIMITIVE_RESTART = 0x8F9D;

	/** Accepted by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetFloatv, and GetDoublev. */
	public static final int GL_PRIMITIVE_RESTART_INDEX = 0x8F9E;

	/**
	 * Accepted by the {@code target} parameter of BindBuffer, BufferData, BufferSubData, MapBuffer, MapBufferRange, BindTexture, UnmapBuffer,
	 * GetBufferSubData, GetBufferParameteriv, GetBufferPointerv, and TexBuffer, and the {@code pname} parameter of GetBooleanv, GetDoublev, GetFloatv, and
	 * GetIntegerv.
	 */
	public static final int GL_TEXTURE_BUFFER = 0x8C2A;

	/** Accepted by the {@code pname} parameters of GetBooleanv, GetDoublev, GetFloatv, and GetIntegerv. */
	public static final int
		GL_MAX_TEXTURE_BUFFER_SIZE           = 0x8C2B,
		GL_TEXTURE_BINDING_BUFFER            = 0x8C2C,
		GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 0x8C2D;

	/**
	 * Accepted by the {@code cap} parameter of Enable, Disable and IsEnabled; by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetFloatv and
	 * GetDoublev; and by the {@code target} parameter of BindTexture, GetTexParameterfv, GetTexParameteriv, TexParameterf, TexParameteri, TexParameterfv and
	 * TexParameteriv.
	 */
	public static final int GL_TEXTURE_RECTANGLE = 0x84F5;

	/** Accepted by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetFloatv and GetDoublev. */
	public static final int GL_TEXTURE_BINDING_RECTANGLE = 0x84F6;

	/** Accepted by the {@code target} parameter of GetTexLevelParameteriv, GetTexLevelParameterfv, GetTexParameteriv and TexImage2D. */
	public static final int GL_PROXY_TEXTURE_RECTANGLE = 0x84F7;

	/** Accepted by the {@code pname} parameter of GetBooleanv, GetDoublev, GetIntegerv and GetFloatv. */
	public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE = 0x84F8;

	/** Returned by {@code type} parameter of GetActiveUniform when the location {@code index} for program object {@code program} is of type sampler2DRect. */
	public static final int GL_SAMPLER_2D_RECT = 0x8B63;

	/**
	 * Returned by {@code type} parameter of GetActiveUniform when the location {@code index} for program object {@code program} is of type
	 * sampler2DRectShadow.
	 */
	public static final int GL_SAMPLER_2D_RECT_SHADOW = 0x8B64;

	/** Accepted by the {@code target} parameters of BindBuffer, BufferData, BufferSubData, MapBuffer, UnmapBuffer, GetBufferSubData, and GetBufferPointerv. */
	public static final int GL_UNIFORM_BUFFER = 0x8A11;

	/** Accepted by the {@code pname} parameter of GetIntegeri_v, GetBooleanv, GetIntegerv, GetFloatv, and GetDoublev. */
	public static final int GL_UNIFORM_BUFFER_BINDING = 0x8A28;

	/** Accepted by the {@code pname} parameter of GetIntegeri_v. */
	public static final int
		GL_UNIFORM_BUFFER_START = 0x8A29,
		GL_UNIFORM_BUFFER_SIZE  = 0x8A2A;

	/** Accepted by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetFloatv, and GetDoublev. */
	public static final int
		GL_MAX_VERTEX_UNIFORM_BLOCKS                = 0x8A2B,
		GL_MAX_GEOMETRY_UNIFORM_BLOCKS              = 0x8A2C,
		GL_MAX_FRAGMENT_UNIFORM_BLOCKS              = 0x8A2D,
		GL_MAX_COMBINED_UNIFORM_BLOCKS              = 0x8A2E,
		GL_MAX_UNIFORM_BUFFER_BINDINGS              = 0x8A2F,
		GL_MAX_UNIFORM_BLOCK_SIZE                   = 0x8A30,
		GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS   = 0x8A31,
		GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 0x8A32,
		GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 0x8A33,
		GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT          = 0x8A34;

	/** Accepted by the {@code pname} parameter of GetProgramiv. */
	public static final int
		GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 0x8A35,
		GL_ACTIVE_UNIFORM_BLOCKS                = 0x8A36;

	/** Accepted by the {@code pname} parameter of GetActiveUniformsiv. */
	public static final int
		GL_UNIFORM_TYPE          = 0x8A37,
		GL_UNIFORM_SIZE          = 0x8A38,
		GL_UNIFORM_NAME_LENGTH   = 0x8A39,
		GL_UNIFORM_BLOCK_INDEX   = 0x8A3A,
		GL_UNIFORM_OFFSET        = 0x8A3B,
		GL_UNIFORM_ARRAY_STRIDE  = 0x8A3C,
		GL_UNIFORM_MATRIX_STRIDE = 0x8A3D,
		GL_UNIFORM_IS_ROW_MAJOR  = 0x8A3E;

	/** Accepted by the {@code pname} parameter of GetActiveUniformBlockiv. */
	public static final int
		GL_UNIFORM_BLOCK_BINDING                       = 0x8A3F,
		GL_UNIFORM_BLOCK_DATA_SIZE                     = 0x8A40,
		GL_UNIFORM_BLOCK_NAME_LENGTH                   = 0x8A41,
		GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS               = 0x8A42,
		GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES        = 0x8A43,
		GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER   = 0x8A44,
		GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 0x8A45,
		GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 0x8A46;

	/** Returned by GetActiveUniformsiv and GetUniformBlockIndex. */
	public static final int GL_INVALID_INDEX = 0xFFFFFFFF;

	protected GL31() {
		throw new UnsupportedOperationException();
	}

	static boolean isAvailable(GLCapabilities caps) {
		return checkFunctions(
			caps.glDrawArraysInstanced, caps.glDrawElementsInstanced, caps.glCopyBufferSubData, caps.glPrimitiveRestartIndex, caps.glTexBuffer, 
			caps.glGetUniformIndices, caps.glGetActiveUniformsiv, caps.glGetActiveUniformName, caps.glGetUniformBlockIndex, caps.glGetActiveUniformBlockiv, 
			caps.glGetActiveUniformBlockName, caps.glUniformBlockBinding
		);
	}

	// --- [ glDrawArraysInstanced ] ---

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glDrawArraysInstanced.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Draw multiple instances of a range of elements.
	 *
	 * @param mode      the kind of primitives to render. One of:<br><table><tr><td>{@link GL11#GL_POINTS POINTS}</td><td>{@link GL11#GL_LINE_STRIP LINE_STRIP}</td><td>{@link GL11#GL_LINE_LOOP LINE_LOOP}</td><td>{@link GL11#GL_LINES LINES}</td><td>{@link GL11#GL_POLYGON POLYGON}</td><td>{@link GL11#GL_TRIANGLE_STRIP TRIANGLE_STRIP}</td><td>{@link GL11#GL_TRIANGLE_FAN TRIANGLE_FAN}</td></tr><tr><td>{@link GL11#GL_TRIANGLES TRIANGLES}</td><td>{@link GL11#GL_QUAD_STRIP QUAD_STRIP}</td><td>{@link GL11#GL_QUADS QUADS}</td><td>{@link GL32#GL_LINES_ADJACENCY LINES_ADJACENCY}</td><td>{@link GL32#GL_LINE_STRIP_ADJACENCY LINE_STRIP_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLES_ADJACENCY TRIANGLES_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLE_STRIP_ADJACENCY TRIANGLE_STRIP_ADJACENCY}</td></tr><tr><td>{@link GL40#GL_PATCHES PATCHES}</td></tr></table>
	 * @param first     the index of the first vertex to be rendered
	 * @param count     the number of vertices to be rendered
	 * @param primcount the number of instances of the specified range of vertices to be rendered
	 */
	public static void glDrawArraysInstanced(int mode, int first, int count, int primcount) {
		long __functionAddress = GL.getCapabilities().glDrawArraysInstanced;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callV(__functionAddress, mode, first, count, primcount);
	}

	// --- [ glDrawElementsInstanced ] ---

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glDrawElementsInstanced.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Draws multiple instances of a set of elements.
	 *
	 * @param mode      the kind of primitives to render. One of:<br><table><tr><td>{@link GL11#GL_POINTS POINTS}</td><td>{@link GL11#GL_LINE_STRIP LINE_STRIP}</td><td>{@link GL11#GL_LINE_LOOP LINE_LOOP}</td><td>{@link GL11#GL_LINES LINES}</td><td>{@link GL11#GL_POLYGON POLYGON}</td><td>{@link GL11#GL_TRIANGLE_STRIP TRIANGLE_STRIP}</td><td>{@link GL11#GL_TRIANGLE_FAN TRIANGLE_FAN}</td></tr><tr><td>{@link GL11#GL_TRIANGLES TRIANGLES}</td><td>{@link GL11#GL_QUAD_STRIP QUAD_STRIP}</td><td>{@link GL11#GL_QUADS QUADS}</td><td>{@link GL32#GL_LINES_ADJACENCY LINES_ADJACENCY}</td><td>{@link GL32#GL_LINE_STRIP_ADJACENCY LINE_STRIP_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLES_ADJACENCY TRIANGLES_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLE_STRIP_ADJACENCY TRIANGLE_STRIP_ADJACENCY}</td></tr><tr><td>{@link GL40#GL_PATCHES PATCHES}</td></tr></table>
	 * @param count     the number of elements to be rendered
	 * @param type      the type of the values in {@code indices}. One of:<br><table><tr><td>{@link GL11#GL_UNSIGNED_BYTE UNSIGNED_BYTE}</td><td>{@link GL11#GL_UNSIGNED_SHORT UNSIGNED_SHORT}</td><td>{@link GL11#GL_UNSIGNED_INT UNSIGNED_INT}</td></tr></table>
	 * @param indices   the ByteBuffer containing the indices to be rendered
	 * @param primcount the number of instances of the specified range of indices to be rendered
	 */
	public static void nglDrawElementsInstanced(int mode, int count, int type, long indices, int primcount) {
		long __functionAddress = GL.getCapabilities().glDrawElementsInstanced;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callPV(__functionAddress, mode, count, type, indices, primcount);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glDrawElementsInstanced.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Draws multiple instances of a set of elements.
	 *
	 * @param mode      the kind of primitives to render. One of:<br><table><tr><td>{@link GL11#GL_POINTS POINTS}</td><td>{@link GL11#GL_LINE_STRIP LINE_STRIP}</td><td>{@link GL11#GL_LINE_LOOP LINE_LOOP}</td><td>{@link GL11#GL_LINES LINES}</td><td>{@link GL11#GL_POLYGON POLYGON}</td><td>{@link GL11#GL_TRIANGLE_STRIP TRIANGLE_STRIP}</td><td>{@link GL11#GL_TRIANGLE_FAN TRIANGLE_FAN}</td></tr><tr><td>{@link GL11#GL_TRIANGLES TRIANGLES}</td><td>{@link GL11#GL_QUAD_STRIP QUAD_STRIP}</td><td>{@link GL11#GL_QUADS QUADS}</td><td>{@link GL32#GL_LINES_ADJACENCY LINES_ADJACENCY}</td><td>{@link GL32#GL_LINE_STRIP_ADJACENCY LINE_STRIP_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLES_ADJACENCY TRIANGLES_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLE_STRIP_ADJACENCY TRIANGLE_STRIP_ADJACENCY}</td></tr><tr><td>{@link GL40#GL_PATCHES PATCHES}</td></tr></table>
	 * @param count     the number of elements to be rendered
	 * @param type      the type of the values in {@code indices}. One of:<br><table><tr><td>{@link GL11#GL_UNSIGNED_BYTE UNSIGNED_BYTE}</td><td>{@link GL11#GL_UNSIGNED_SHORT UNSIGNED_SHORT}</td><td>{@link GL11#GL_UNSIGNED_INT UNSIGNED_INT}</td></tr></table>
	 * @param indices   the ByteBuffer containing the indices to be rendered
	 * @param primcount the number of instances of the specified range of indices to be rendered
	 */
	public static void glDrawElementsInstanced(int mode, int count, int type, long indices, int primcount) {
		if ( CHECKS )
			GLChecks.ensureBufferObject(GL15.GL_ELEMENT_ARRAY_BUFFER_BINDING, true);
		nglDrawElementsInstanced(mode, count, type, indices, primcount);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glDrawElementsInstanced.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Draws multiple instances of a set of elements.
	 *
	 * @param mode      the kind of primitives to render. One of:<br><table><tr><td>{@link GL11#GL_POINTS POINTS}</td><td>{@link GL11#GL_LINE_STRIP LINE_STRIP}</td><td>{@link GL11#GL_LINE_LOOP LINE_LOOP}</td><td>{@link GL11#GL_LINES LINES}</td><td>{@link GL11#GL_POLYGON POLYGON}</td><td>{@link GL11#GL_TRIANGLE_STRIP TRIANGLE_STRIP}</td><td>{@link GL11#GL_TRIANGLE_FAN TRIANGLE_FAN}</td></tr><tr><td>{@link GL11#GL_TRIANGLES TRIANGLES}</td><td>{@link GL11#GL_QUAD_STRIP QUAD_STRIP}</td><td>{@link GL11#GL_QUADS QUADS}</td><td>{@link GL32#GL_LINES_ADJACENCY LINES_ADJACENCY}</td><td>{@link GL32#GL_LINE_STRIP_ADJACENCY LINE_STRIP_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLES_ADJACENCY TRIANGLES_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLE_STRIP_ADJACENCY TRIANGLE_STRIP_ADJACENCY}</td></tr><tr><td>{@link GL40#GL_PATCHES PATCHES}</td></tr></table>
	 * @param type      the type of the values in {@code indices}. One of:<br><table><tr><td>{@link GL11#GL_UNSIGNED_BYTE UNSIGNED_BYTE}</td><td>{@link GL11#GL_UNSIGNED_SHORT UNSIGNED_SHORT}</td><td>{@link GL11#GL_UNSIGNED_INT UNSIGNED_INT}</td></tr></table>
	 * @param indices   the ByteBuffer containing the indices to be rendered
	 * @param primcount the number of instances of the specified range of indices to be rendered
	 */
	public static void glDrawElementsInstanced(int mode, int type, ByteBuffer indices, int primcount) {
		if ( CHECKS )
			GLChecks.ensureBufferObject(GL15.GL_ELEMENT_ARRAY_BUFFER_BINDING, false);
		nglDrawElementsInstanced(mode, indices.remaining() >> GLChecks.typeToByteShift(type), type, memAddress(indices), primcount);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glDrawElementsInstanced.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Draws multiple instances of a set of elements.
	 *
	 * @param mode      the kind of primitives to render. One of:<br><table><tr><td>{@link GL11#GL_POINTS POINTS}</td><td>{@link GL11#GL_LINE_STRIP LINE_STRIP}</td><td>{@link GL11#GL_LINE_LOOP LINE_LOOP}</td><td>{@link GL11#GL_LINES LINES}</td><td>{@link GL11#GL_POLYGON POLYGON}</td><td>{@link GL11#GL_TRIANGLE_STRIP TRIANGLE_STRIP}</td><td>{@link GL11#GL_TRIANGLE_FAN TRIANGLE_FAN}</td></tr><tr><td>{@link GL11#GL_TRIANGLES TRIANGLES}</td><td>{@link GL11#GL_QUAD_STRIP QUAD_STRIP}</td><td>{@link GL11#GL_QUADS QUADS}</td><td>{@link GL32#GL_LINES_ADJACENCY LINES_ADJACENCY}</td><td>{@link GL32#GL_LINE_STRIP_ADJACENCY LINE_STRIP_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLES_ADJACENCY TRIANGLES_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLE_STRIP_ADJACENCY TRIANGLE_STRIP_ADJACENCY}</td></tr><tr><td>{@link GL40#GL_PATCHES PATCHES}</td></tr></table>
	 * @param indices   the ByteBuffer containing the indices to be rendered
	 * @param primcount the number of instances of the specified range of indices to be rendered
	 */
	public static void glDrawElementsInstanced(int mode, ByteBuffer indices, int primcount) {
		if ( CHECKS )
			GLChecks.ensureBufferObject(GL15.GL_ELEMENT_ARRAY_BUFFER_BINDING, false);
		nglDrawElementsInstanced(mode, indices.remaining(), GL11.GL_UNSIGNED_BYTE, memAddress(indices), primcount);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glDrawElementsInstanced.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Draws multiple instances of a set of elements.
	 *
	 * @param mode      the kind of primitives to render. One of:<br><table><tr><td>{@link GL11#GL_POINTS POINTS}</td><td>{@link GL11#GL_LINE_STRIP LINE_STRIP}</td><td>{@link GL11#GL_LINE_LOOP LINE_LOOP}</td><td>{@link GL11#GL_LINES LINES}</td><td>{@link GL11#GL_POLYGON POLYGON}</td><td>{@link GL11#GL_TRIANGLE_STRIP TRIANGLE_STRIP}</td><td>{@link GL11#GL_TRIANGLE_FAN TRIANGLE_FAN}</td></tr><tr><td>{@link GL11#GL_TRIANGLES TRIANGLES}</td><td>{@link GL11#GL_QUAD_STRIP QUAD_STRIP}</td><td>{@link GL11#GL_QUADS QUADS}</td><td>{@link GL32#GL_LINES_ADJACENCY LINES_ADJACENCY}</td><td>{@link GL32#GL_LINE_STRIP_ADJACENCY LINE_STRIP_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLES_ADJACENCY TRIANGLES_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLE_STRIP_ADJACENCY TRIANGLE_STRIP_ADJACENCY}</td></tr><tr><td>{@link GL40#GL_PATCHES PATCHES}</td></tr></table>
	 * @param indices   the ByteBuffer containing the indices to be rendered
	 * @param primcount the number of instances of the specified range of indices to be rendered
	 */
	public static void glDrawElementsInstanced(int mode, ShortBuffer indices, int primcount) {
		if ( CHECKS )
			GLChecks.ensureBufferObject(GL15.GL_ELEMENT_ARRAY_BUFFER_BINDING, false);
		nglDrawElementsInstanced(mode, indices.remaining(), GL11.GL_UNSIGNED_SHORT, memAddress(indices), primcount);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glDrawElementsInstanced.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Draws multiple instances of a set of elements.
	 *
	 * @param mode      the kind of primitives to render. One of:<br><table><tr><td>{@link GL11#GL_POINTS POINTS}</td><td>{@link GL11#GL_LINE_STRIP LINE_STRIP}</td><td>{@link GL11#GL_LINE_LOOP LINE_LOOP}</td><td>{@link GL11#GL_LINES LINES}</td><td>{@link GL11#GL_POLYGON POLYGON}</td><td>{@link GL11#GL_TRIANGLE_STRIP TRIANGLE_STRIP}</td><td>{@link GL11#GL_TRIANGLE_FAN TRIANGLE_FAN}</td></tr><tr><td>{@link GL11#GL_TRIANGLES TRIANGLES}</td><td>{@link GL11#GL_QUAD_STRIP QUAD_STRIP}</td><td>{@link GL11#GL_QUADS QUADS}</td><td>{@link GL32#GL_LINES_ADJACENCY LINES_ADJACENCY}</td><td>{@link GL32#GL_LINE_STRIP_ADJACENCY LINE_STRIP_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLES_ADJACENCY TRIANGLES_ADJACENCY}</td><td>{@link GL32#GL_TRIANGLE_STRIP_ADJACENCY TRIANGLE_STRIP_ADJACENCY}</td></tr><tr><td>{@link GL40#GL_PATCHES PATCHES}</td></tr></table>
	 * @param indices   the ByteBuffer containing the indices to be rendered
	 * @param primcount the number of instances of the specified range of indices to be rendered
	 */
	public static void glDrawElementsInstanced(int mode, IntBuffer indices, int primcount) {
		if ( CHECKS )
			GLChecks.ensureBufferObject(GL15.GL_ELEMENT_ARRAY_BUFFER_BINDING, false);
		nglDrawElementsInstanced(mode, indices.remaining(), GL11.GL_UNSIGNED_INT, memAddress(indices), primcount);
	}

	// --- [ glCopyBufferSubData ] ---

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glCopyBufferSubData.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Copies all or part of one buffer object's data store to the data store of another buffer object.
	 * 
	 * <p>An {@link GL11#GL_INVALID_VALUE INVALID_VALUE} error is generated if any of readoffset, writeoffset, or size are negative, if readoffset+size exceeds the size of the buffer object
	 * bound to readtarget, or if writeoffset+size exceeds the size of the buffer object bound to writetarget.</p>
	 * 
	 * <p>An {@link GL11#GL_INVALID_VALUE INVALID_VALUE} error is generated if the same buffer object is bound to both readtarget and writetarget, and the ranges [readoffset, readoffset+size)
	 * and [writeoffset, writeoffset+size) overlap.</p>
	 * 
	 * <p>An {@link GL11#GL_INVALID_OPERATION INVALID_OPERATION} error is generated if zero is bound to readtarget or writetarget.</p>
	 * 
	 * <p>An {@link GL11#GL_INVALID_OPERATION INVALID_OPERATION} error is generated if the buffer objects bound to either readtarget or writetarget are mapped.</p>
	 *
	 * @param readTarget  the source buffer object target. One of:<br><table><tr><td>{@link GL15#GL_ARRAY_BUFFER ARRAY_BUFFER}</td><td>{@link #GL_COPY_READ_BUFFER COPY_READ_BUFFER}</td><td>{@link #GL_COPY_WRITE_BUFFER COPY_WRITE_BUFFER}</td><td>{@link GL15#GL_ELEMENT_ARRAY_BUFFER ELEMENT_ARRAY_BUFFER}</td></tr><tr><td>{@link GL21#GL_PIXEL_PACK_BUFFER PIXEL_PACK_BUFFER}</td><td>{@link GL21#GL_PIXEL_UNPACK_BUFFER PIXEL_UNPACK_BUFFER}</td><td>{@link GL30#GL_TRANSFORM_FEEDBACK_BUFFER TRANSFORM_FEEDBACK_BUFFER}</td><td>{@link #GL_TEXTURE_BUFFER TEXTURE_BUFFER}</td></tr><tr><td>{@link #GL_UNIFORM_BUFFER UNIFORM_BUFFER}</td></tr></table>
	 * @param writeTarget the destination buffer object target
	 * @param readOffset  the source buffer object offset, in bytes
	 * @param writeOffset the destination buffer object offset, in bytes
	 * @param size        the number of bytes to copy
	 */
	public static void glCopyBufferSubData(int readTarget, int writeTarget, long readOffset, long writeOffset, long size) {
		long __functionAddress = GL.getCapabilities().glCopyBufferSubData;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callPPPV(__functionAddress, readTarget, writeTarget, readOffset, writeOffset, size);
	}

	// --- [ glPrimitiveRestartIndex ] ---

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glPrimitiveRestartIndex.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Specifies the primitive restart index.
	 *
	 * @param index the value to be interpreted as the primitive restart index
	 */
	public static void glPrimitiveRestartIndex(int index) {
		long __functionAddress = GL.getCapabilities().glPrimitiveRestartIndex;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callV(__functionAddress, index);
	}

	// --- [ glTexBuffer ] ---

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glTexBuffer.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Attaches the storage for the buffer object named {@code buffer} to the active buffer texture, and specifies an internal format for the texel array found
	 * in the attached buffer object. If {@code buffer} is zero, any buffer object attached to the buffer texture is detached, and no new buffer object is
	 * attached. If {@code buffer} is non-zero, but is not the name of an existing buffer object, the error {@link GL11#GL_INVALID_OPERATION INVALID_OPERATION} is generated.
	 * 
	 * <p>When a buffer object is attached to a buffer texture, the buffer object's data store is taken as the texture's texel array. The number of texels in the
	 * buffer texture's texel array is given by</p>
	 * 
	 * <p><code>floor(buffer_size / (components * sizeof(base_type))</code>,</p>
	 * 
	 * <p>where {@code buffer_size} is the size of the buffer object, in basic machine units and {@code components} and {@code base_type} are the element count
	 * and base data type for elements. The number of texels in the texel array is then clamped to the implementation-dependent limit {@link #GL_MAX_TEXTURE_BUFFER_SIZE MAX_TEXTURE_BUFFER_SIZE}.
	 * When a buffer texture is accessed in a shader, the results of a texel fetch are undefined if the specified texel number is greater than or equal to the
	 * clamped number of texels in the texel array.</p>
	 * 
	 * <p>When a buffer texture is accessed in a shader, an integer is provided to indicate the texel number being accessed. If no buffer object is bound to the
	 * buffer texture, the results of the texel access are undefined. Otherwise, the attached buffer object's data store is interpreted as an array of elements
	 * of the GL data type corresponding to {@code internalformat}. Each texel consists of one to four elements that are mapped to texture components
	 * (R, G, B, A, L, and I). Element {@code m} of the texel numbered {@code n} is taken from element {@code n} * {@code components} + {@code m} of the
	 * attached buffer object's data store. Elements and texels are both numbered starting with zero. For texture formats with normalized components, the
	 * extracted values are converted to floating-point values. The components of the texture are then converted to an (R,G,B,A) vector, and returned to the
	 * shader as a four-component result vector with components of the appropriate data type for the texture's internal format.</p>
	 *
	 * @param target         the target of the operation. Must be:<br><table><tr><td>{@link #GL_TEXTURE_BUFFER TEXTURE_BUFFER}</td></tr></table>
	 * @param internalformat the sized internal format of the data in the store belonging to {@code buffer}
	 * @param buffer         the name of the buffer object whose storage to attach to the active buffer texture
	 */
	public static void glTexBuffer(int target, int internalformat, int buffer) {
		long __functionAddress = GL.getCapabilities().glTexBuffer;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callV(__functionAddress, target, internalformat, buffer);
	}

	// --- [ glGetUniformIndices ] ---

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetUniformIndices.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Retrieves the indices of a number of uniforms within a program object
	 *
	 * @param program        the name of a program containing uniforms whose indices to query
	 * @param uniformCount   the number of uniforms whose indices to query
	 * @param uniformNames   an array of pointers to buffers containing the names of the queried uniforms
	 * @param uniformIndices an array that will receive the indices of the uniforms
	 */
	public static void nglGetUniformIndices(int program, int uniformCount, long uniformNames, long uniformIndices) {
		long __functionAddress = GL.getCapabilities().glGetUniformIndices;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callPPV(__functionAddress, program, uniformCount, uniformNames, uniformIndices);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetUniformIndices.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Retrieves the indices of a number of uniforms within a program object
	 *
	 * @param program        the name of a program containing uniforms whose indices to query
	 * @param uniformNames   an array of pointers to buffers containing the names of the queried uniforms
	 * @param uniformIndices an array that will receive the indices of the uniforms
	 */
	public static void glGetUniformIndices(int program, PointerBuffer uniformNames, IntBuffer uniformIndices) {
		if ( CHECKS )
			checkBuffer(uniformIndices, uniformNames.remaining());
		nglGetUniformIndices(program, uniformNames.remaining(), memAddress(uniformNames), memAddress(uniformIndices));
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetUniformIndices.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Retrieves the indices of a number of uniforms within a program object
	 *
	 * @param program        the name of a program containing uniforms whose indices to query
	 * @param uniformNames   an array of pointers to buffers containing the names of the queried uniforms
	 * @param uniformIndices an array that will receive the indices of the uniforms
	 */
	public static void glGetUniformIndices(int program, CharSequence[] uniformNames, IntBuffer uniformIndices) {
		if ( CHECKS )
			checkBuffer(uniformIndices, uniformNames.length);
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			long uniformNamesAddress = org.lwjgl.system.APIUtil.apiArray(stack, MemoryUtil::memASCII, uniformNames);
			nglGetUniformIndices(program, uniformNames.length, uniformNamesAddress, memAddress(uniformIndices));
			org.lwjgl.system.APIUtil.apiArrayFree(uniformNamesAddress, uniformNames.length);
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetUniformIndices.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Retrieves the indices of a number of uniforms within a program object
	 *
	 * @param program the name of a program containing uniforms whose indices to query
	 */
	public static int glGetUniformIndices(int program, CharSequence uniformName) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			long uniformNamesAddress = org.lwjgl.system.APIUtil.apiArray(stack, MemoryUtil::memASCII, uniformName);
			IntBuffer uniformIndices = stack.callocInt(1);
			nglGetUniformIndices(program, 1, uniformNamesAddress, memAddress(uniformIndices));
			org.lwjgl.system.APIUtil.apiArrayFree(uniformNamesAddress, 1);
			return uniformIndices.get(0);
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ glGetActiveUniformsiv ] ---

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniforms.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Returns information about several active uniform variables for the specified program object.
	 *
	 * @param program        the program object to be queried
	 * @param uniformCount   the number of elements in the array of indices {@code uniformIndices} and the number of parameters written to {@code params} upon successful return
	 * @param uniformIndices an array of {@code uniformCount} integers containing the indices of uniforms within {@code program}
	 * @param pname          the property of the each uniform in {@code uniformIndices} that should be written into the corresponding element of {@code params}
	 * @param params         an array of {@code uniformCount} integers which are to receive the value of {@code pname} for each uniform in {@code uniformIndices}
	 */
	public static void nglGetActiveUniformsiv(int program, int uniformCount, long uniformIndices, int pname, long params) {
		long __functionAddress = GL.getCapabilities().glGetActiveUniformsiv;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callPPV(__functionAddress, program, uniformCount, uniformIndices, pname, params);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniforms.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Returns information about several active uniform variables for the specified program object.
	 *
	 * @param program        the program object to be queried
	 * @param uniformIndices an array of {@code uniformCount} integers containing the indices of uniforms within {@code program}
	 * @param pname          the property of the each uniform in {@code uniformIndices} that should be written into the corresponding element of {@code params}
	 * @param params         an array of {@code uniformCount} integers which are to receive the value of {@code pname} for each uniform in {@code uniformIndices}
	 */
	public static void glGetActiveUniformsiv(int program, IntBuffer uniformIndices, int pname, IntBuffer params) {
		if ( CHECKS )
			checkBuffer(params, uniformIndices.remaining());
		nglGetActiveUniformsiv(program, uniformIndices.remaining(), memAddress(uniformIndices), pname, memAddress(params));
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniforms.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Returns information about several active uniform variables for the specified program object.
	 *
	 * @param program the program object to be queried
	 * @param pname   the property of the each uniform in {@code uniformIndices} that should be written into the corresponding element of {@code params}
	 */
	public static int glGetActiveUniformsi(int program, int uniformIndex, int pname) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			IntBuffer params = stack.callocInt(1);
			IntBuffer uniformIndices = stack.ints(uniformIndex);
			nglGetActiveUniformsiv(program, 1, memAddress(uniformIndices), pname, memAddress(params));
			return params.get(0);
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ glGetActiveUniformName ] ---

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformName.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Queries the name of an active uniform.
	 *
	 * @param program      the program containing the active uniform index {@code uniformIndex}
	 * @param uniformIndex the index of the active uniform whose name to query
	 * @param bufSize      the size of the buffer, in units of {@code GLchar}, of the buffer whose address is specified in {@code uniformName}
	 * @param length       the address of a variable that will receive the number of characters that were or would have been written to the buffer addressed by {@code uniformName}
	 * @param uniformName  the address of a buffer into which the GL will place the name of the active uniform at {@code uniformIndex} within {@code program}
	 */
	public static void nglGetActiveUniformName(int program, int uniformIndex, int bufSize, long length, long uniformName) {
		long __functionAddress = GL.getCapabilities().glGetActiveUniformName;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callPPV(__functionAddress, program, uniformIndex, bufSize, length, uniformName);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformName.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Queries the name of an active uniform.
	 *
	 * @param program      the program containing the active uniform index {@code uniformIndex}
	 * @param uniformIndex the index of the active uniform whose name to query
	 * @param length       the address of a variable that will receive the number of characters that were or would have been written to the buffer addressed by {@code uniformName}
	 * @param uniformName  the address of a buffer into which the GL will place the name of the active uniform at {@code uniformIndex} within {@code program}
	 */
	public static void glGetActiveUniformName(int program, int uniformIndex, IntBuffer length, ByteBuffer uniformName) {
		if ( CHECKS )
			if ( length != null ) checkBuffer(length, 1);
		nglGetActiveUniformName(program, uniformIndex, uniformName.remaining(), memAddressSafe(length), memAddress(uniformName));
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformName.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Queries the name of an active uniform.
	 *
	 * @param program      the program containing the active uniform index {@code uniformIndex}
	 * @param uniformIndex the index of the active uniform whose name to query
	 * @param bufSize      the size of the buffer, in units of {@code GLchar}, of the buffer whose address is specified in {@code uniformName}
	 */
	public static String glGetActiveUniformName(int program, int uniformIndex, int bufSize) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			IntBuffer length = stack.ints(0);
			ByteBuffer uniformName = stack.malloc(bufSize);
			nglGetActiveUniformName(program, uniformIndex, bufSize, memAddress(length), memAddress(uniformName));
			return memASCII(uniformName, length.get(0));
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformName.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Queries the name of an active uniform.
	 *
	 * @param program      the program containing the active uniform index {@code uniformIndex}
	 * @param uniformIndex the index of the active uniform whose name to query
	 */
	public static String glGetActiveUniformName(int program, int uniformIndex) {
		int bufSize = glGetActiveUniformsi(program, uniformIndex, GL_UNIFORM_NAME_LENGTH);
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			IntBuffer length = stack.ints(0);
			ByteBuffer uniformName = stack.malloc(bufSize);
			nglGetActiveUniformName(program, uniformIndex, bufSize, memAddress(length), memAddress(uniformName));
			return memASCII(uniformName, length.get(0));
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ glGetUniformBlockIndex ] ---

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetUniformBlockIndex.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Retrieves the index of a named uniform block.
	 *
	 * @param program          the name of a program containing the uniform block
	 * @param uniformBlockName an array of characters to containing the name of the uniform block whose index to retrieve
	 */
	public static int nglGetUniformBlockIndex(int program, long uniformBlockName) {
		long __functionAddress = GL.getCapabilities().glGetUniformBlockIndex;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		return callPI(__functionAddress, program, uniformBlockName);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetUniformBlockIndex.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Retrieves the index of a named uniform block.
	 *
	 * @param program          the name of a program containing the uniform block
	 * @param uniformBlockName an array of characters to containing the name of the uniform block whose index to retrieve
	 */
	public static int glGetUniformBlockIndex(int program, ByteBuffer uniformBlockName) {
		if ( CHECKS )
			checkNT1(uniformBlockName);
		return nglGetUniformBlockIndex(program, memAddress(uniformBlockName));
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetUniformBlockIndex.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Retrieves the index of a named uniform block.
	 *
	 * @param program          the name of a program containing the uniform block
	 * @param uniformBlockName an array of characters to containing the name of the uniform block whose index to retrieve
	 */
	public static int glGetUniformBlockIndex(int program, CharSequence uniformBlockName) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			ByteBuffer uniformBlockNameEncoded = stack.ASCII(uniformBlockName);
			return nglGetUniformBlockIndex(program, memAddress(uniformBlockNameEncoded));
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ glGetActiveUniformBlockiv ] ---

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformBlock.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Queries information about an active uniform block.
	 *
	 * @param program           the name of a program containing the uniform block
	 * @param uniformBlockIndex the index of the uniform block within {@code program}
	 * @param pname             the name of the parameter to query. One of:<br><table><tr><td>{@link #GL_UNIFORM_BLOCK_BINDING UNIFORM_BLOCK_BINDING}</td><td>{@link #GL_UNIFORM_BLOCK_DATA_SIZE UNIFORM_BLOCK_DATA_SIZE}</td></tr><tr><td>{@link #GL_UNIFORM_BLOCK_NAME_LENGTH UNIFORM_BLOCK_NAME_LENGTH}</td><td>{@link #GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS UNIFORM_BLOCK_ACTIVE_UNIFORMS}</td></tr><tr><td>{@link #GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES}</td><td>{@link #GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER}</td></tr><tr><td>{@link #GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER}</td><td>{@link #GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER}</td></tr></table>
	 * @param params            the address of a variable to receive the result of the query
	 */
	public static void nglGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, long params) {
		long __functionAddress = GL.getCapabilities().glGetActiveUniformBlockiv;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callPV(__functionAddress, program, uniformBlockIndex, pname, params);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformBlock.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Queries information about an active uniform block.
	 *
	 * @param program           the name of a program containing the uniform block
	 * @param uniformBlockIndex the index of the uniform block within {@code program}
	 * @param pname             the name of the parameter to query. One of:<br><table><tr><td>{@link #GL_UNIFORM_BLOCK_BINDING UNIFORM_BLOCK_BINDING}</td><td>{@link #GL_UNIFORM_BLOCK_DATA_SIZE UNIFORM_BLOCK_DATA_SIZE}</td></tr><tr><td>{@link #GL_UNIFORM_BLOCK_NAME_LENGTH UNIFORM_BLOCK_NAME_LENGTH}</td><td>{@link #GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS UNIFORM_BLOCK_ACTIVE_UNIFORMS}</td></tr><tr><td>{@link #GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES}</td><td>{@link #GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER}</td></tr><tr><td>{@link #GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER}</td><td>{@link #GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER}</td></tr></table>
	 * @param params            the address of a variable to receive the result of the query
	 */
	public static void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, IntBuffer params) {
		if ( CHECKS )
			checkBuffer(params, 1);
		nglGetActiveUniformBlockiv(program, uniformBlockIndex, pname, memAddress(params));
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformBlock.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Queries information about an active uniform block.
	 *
	 * @param program           the name of a program containing the uniform block
	 * @param uniformBlockIndex the index of the uniform block within {@code program}
	 * @param pname             the name of the parameter to query. One of:<br><table><tr><td>{@link #GL_UNIFORM_BLOCK_BINDING UNIFORM_BLOCK_BINDING}</td><td>{@link #GL_UNIFORM_BLOCK_DATA_SIZE UNIFORM_BLOCK_DATA_SIZE}</td></tr><tr><td>{@link #GL_UNIFORM_BLOCK_NAME_LENGTH UNIFORM_BLOCK_NAME_LENGTH}</td><td>{@link #GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS UNIFORM_BLOCK_ACTIVE_UNIFORMS}</td></tr><tr><td>{@link #GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES}</td><td>{@link #GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER}</td></tr><tr><td>{@link #GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER}</td><td>{@link #GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER}</td></tr></table>
	 */
	public static int glGetActiveUniformBlocki(int program, int uniformBlockIndex, int pname) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			IntBuffer params = stack.callocInt(1);
			nglGetActiveUniformBlockiv(program, uniformBlockIndex, pname, memAddress(params));
			return params.get(0);
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ glGetActiveUniformBlockName ] ---

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformBlockName.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Retrieves the name of an active uniform block.
	 *
	 * @param program           the name of a program containing the uniform block
	 * @param uniformBlockIndex the index of the uniform block within {@code program}
	 * @param bufSize           the size of the buffer addressed by {@code uniformBlockName}
	 * @param length            the address of a variable to receive the number of characters that were written to {@code uniformBlockName}
	 * @param uniformBlockName  an array of characters to receive the name of the uniform block at {@code uniformBlockIndex}
	 */
	public static void nglGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, long length, long uniformBlockName) {
		long __functionAddress = GL.getCapabilities().glGetActiveUniformBlockName;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callPPV(__functionAddress, program, uniformBlockIndex, bufSize, length, uniformBlockName);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformBlockName.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Retrieves the name of an active uniform block.
	 *
	 * @param program           the name of a program containing the uniform block
	 * @param uniformBlockIndex the index of the uniform block within {@code program}
	 * @param length            the address of a variable to receive the number of characters that were written to {@code uniformBlockName}
	 * @param uniformBlockName  an array of characters to receive the name of the uniform block at {@code uniformBlockIndex}
	 */
	public static void glGetActiveUniformBlockName(int program, int uniformBlockIndex, IntBuffer length, ByteBuffer uniformBlockName) {
		if ( CHECKS )
			if ( length != null ) checkBuffer(length, 1);
		nglGetActiveUniformBlockName(program, uniformBlockIndex, uniformBlockName.remaining(), memAddressSafe(length), memAddress(uniformBlockName));
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformBlockName.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Retrieves the name of an active uniform block.
	 *
	 * @param program           the name of a program containing the uniform block
	 * @param uniformBlockIndex the index of the uniform block within {@code program}
	 * @param bufSize           the size of the buffer addressed by {@code uniformBlockName}
	 */
	public static String glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			IntBuffer length = stack.ints(0);
			ByteBuffer uniformBlockName = stack.malloc(bufSize);
			nglGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, memAddress(length), memAddress(uniformBlockName));
			return memASCII(uniformBlockName, length.get(0));
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformBlockName.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Retrieves the name of an active uniform block.
	 *
	 * @param program           the name of a program containing the uniform block
	 * @param uniformBlockIndex the index of the uniform block within {@code program}
	 */
	public static String glGetActiveUniformBlockName(int program, int uniformBlockIndex) {
		int bufSize = glGetActiveUniformBlocki(program, uniformBlockIndex, GL_UNIFORM_BLOCK_NAME_LENGTH);
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			IntBuffer length = stack.ints(0);
			ByteBuffer uniformBlockName = stack.malloc(bufSize);
			nglGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, memAddress(length), memAddress(uniformBlockName));
			return memASCII(uniformBlockName, length.get(0));
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ glUniformBlockBinding ] ---

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glUniformBlockBinding.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Assigns a binding point to an active uniform block.
	 *
	 * @param program             the name of a program object containing the active uniform block whose binding to assign
	 * @param uniformBlockIndex   the index of the active uniform block within {@code program} whose binding to assign
	 * @param uniformBlockBinding the binding point to which to bind the uniform block with index {@code uniformBlockIndex} within {@code program}
	 */
	public static void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) {
		long __functionAddress = GL.getCapabilities().glUniformBlockBinding;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callV(__functionAddress, program, uniformBlockIndex, uniformBlockBinding);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetUniformIndices.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Array version of: {@link #glGetUniformIndices GetUniformIndices}
	 */
	public static void glGetUniformIndices(int program, PointerBuffer uniformNames, int[] uniformIndices) {
		long __functionAddress = GL.getCapabilities().glGetUniformIndices;
		if ( CHECKS ) {
			checkFunctionAddress(__functionAddress);
			checkBuffer(uniformIndices, uniformNames.remaining());
		}
		callPPV(__functionAddress, program, uniformNames.remaining(), memAddress(uniformNames), uniformIndices);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniforms.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Array version of: {@link #glGetActiveUniformsiv GetActiveUniformsiv}
	 */
	public static void glGetActiveUniformsiv(int program, int[] uniformIndices, int pname, int[] params) {
		long __functionAddress = GL.getCapabilities().glGetActiveUniformsiv;
		if ( CHECKS ) {
			checkFunctionAddress(__functionAddress);
			checkBuffer(params, uniformIndices.length);
		}
		callPPV(__functionAddress, program, uniformIndices.length, uniformIndices, pname, params);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformName.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Array version of: {@link #glGetActiveUniformName GetActiveUniformName}
	 */
	public static void glGetActiveUniformName(int program, int uniformIndex, int[] length, ByteBuffer uniformName) {
		long __functionAddress = GL.getCapabilities().glGetActiveUniformName;
		if ( CHECKS ) {
			checkFunctionAddress(__functionAddress);
			if ( length != null ) checkBuffer(length, 1);
		}
		callPPV(__functionAddress, program, uniformIndex, uniformName.remaining(), length, memAddress(uniformName));
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformBlock.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Array version of: {@link #glGetActiveUniformBlockiv GetActiveUniformBlockiv}
	 */
	public static void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, int[] params) {
		long __functionAddress = GL.getCapabilities().glGetActiveUniformBlockiv;
		if ( CHECKS ) {
			checkFunctionAddress(__functionAddress);
			checkBuffer(params, 1);
		}
		callPV(__functionAddress, program, uniformBlockIndex, pname, params);
	}

	/**
	 * <p><a href="http://www.opengl.org/sdk/docs/man/html/glGetActiveUniformBlockName.xhtml">OpenGL SDK Reference</a></p>
	 * 
	 * Array version of: {@link #glGetActiveUniformBlockName GetActiveUniformBlockName}
	 */
	public static void glGetActiveUniformBlockName(int program, int uniformBlockIndex, int[] length, ByteBuffer uniformBlockName) {
		long __functionAddress = GL.getCapabilities().glGetActiveUniformBlockName;
		if ( CHECKS ) {
			checkFunctionAddress(__functionAddress);
			if ( length != null ) checkBuffer(length, 1);
		}
		callPPV(__functionAddress, program, uniformBlockIndex, uniformBlockName.remaining(), length, memAddress(uniformBlockName));
	}

}