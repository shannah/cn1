#define NO_USE_ES2 1
#ifdef USE_ES2
#import <GLKit/GLKit.h>
#import <OpenGLES/ES2/gl.h>
#import "ExecutableOp.h"

extern void glMatrixModeES2(GLenum);
extern void glOrthofES2(GLfloat,GLfloat,GLfloat,GLfloat,GLfloat,GLfloat);
extern void glDisableES2(GLenum);
extern void glEnableES2(GLenum);
extern void glScalefES2(GLfloat,GLfloat,GLfloat);
extern void glTranslatefES2(GLfloat,GLfloat,GLfloat);
extern void glColor4fES2(GLfloat,GLfloat,GLfloat,GLfloat);
extern void glEnableClientStateES2(GLenum);
extern void glDisableClientStateES2(GLenum);
extern void glTexCoordPointerES2(GLint,GLenum,GLsizei,const GLvoid*);
extern void glVertexPointerES2(	GLint, GLenum , GLsizei, const GLvoid *);
extern void glDrawArrays(GLenum, GLint, GLsizei);
extern void glRotatef(GLfloat,GLfloat,GLfloat,GLfloat);
#define _glMatrixMode(foo) glMatrixModeES2(foo)
#define _glLoadIdentity()  glLoadIdentityES2()
#define _glOrthof(p1,p2,p3,p4,p5,p6) glOrthofES2(p1,p2,p3,p4,p5,p6)
#define _glDisable(foo) glDisableES2(foo)
#define _glEnable(foo) glEnableES2(foo)
#define _glScalef(xScale,yScale,zScale) glScalefES2(xScale,yScale,zScale)
#define _glTranslatef(xScale,yScale,zScale) glTranslatefES2(xScale,yScale,zScale)
#define _glColor4f(r,g,b,a) glColor4fES2(r,g,b,a)
#define _glEnableClientState(s) glEnableClientStateES2(s)
#define _glDisableClientState(s) glDisableClientStateES2(s)
#define _glTexCoordPointer(size,type,stride,pointer) glTexCoordPointerES2(size,type,stride,pointer)
#define _glVertexPointer(size,type,stride,pointer) glVertexPointerES2(size,type,stride,pointer)
#define _glDrawArrays(mode,first,count) glDrawArraysES2(mode,first,count)
#define _glRotatef(angle,x,y,z) glRotatefES2(angle,x,y,z)
#else
#define _glMatrixMode(foo) glMatrixMode(foo)
#define _glLoadIdentity()  glLoadIdentity()
#define _glOrthof(p1,p2,p3,p4,p5,p6) glOrthof(p1,p2,p3,p4,p5,p6)
#define _glDisable(foo) glDisable(foo)
#define _glEnable(foo) glEnable(foo)
#define _glScalef(xScale,yScale,zScale) glScalef(xScale,yScale,zScale)
#define _glTranslatef(xScale,yScale,zScale) glTranslatef(xScale,yScale,zScale)
#define _glColor4f(r,g,b,a) glColor4f(r,g,b,a)
#define _glEnableClientState(s) glEnableClientState(s)
#define _glDisableClientState(s) glDisableClientState(s)
#define _glTexCoordPointer(size,type,stride,pointer) glTexCoordPointer(size,type,stride,pointer)
#define _glVertexPointer(size, type, stride, pointer) glVertexPointer(size, type, stride, pointer)
#define _glDrawArrays(mode,first,count) glDrawArrays(mode,first,count)
#define _glRotatef(angle,x,y,z) glRotatef(angle,x,y,z)
#endif
