# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.10

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2018.1.5\bin\cmake\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2018.1.5\bin\cmake\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Users\Krishna\CLionProjects\SudokuSolver

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Users\Krishna\CLionProjects\SudokuSolver\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/SudokuSolver.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/SudokuSolver.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/SudokuSolver.dir/flags.make

CMakeFiles/SudokuSolver.dir/main.cpp.obj: CMakeFiles/SudokuSolver.dir/flags.make
CMakeFiles/SudokuSolver.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\Krishna\CLionProjects\SudokuSolver\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/SudokuSolver.dir/main.cpp.obj"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\SudokuSolver.dir\main.cpp.obj -c C:\Users\Krishna\CLionProjects\SudokuSolver\main.cpp

CMakeFiles/SudokuSolver.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/SudokuSolver.dir/main.cpp.i"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\Users\Krishna\CLionProjects\SudokuSolver\main.cpp > CMakeFiles\SudokuSolver.dir\main.cpp.i

CMakeFiles/SudokuSolver.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/SudokuSolver.dir/main.cpp.s"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\Users\Krishna\CLionProjects\SudokuSolver\main.cpp -o CMakeFiles\SudokuSolver.dir\main.cpp.s

CMakeFiles/SudokuSolver.dir/main.cpp.obj.requires:

.PHONY : CMakeFiles/SudokuSolver.dir/main.cpp.obj.requires

CMakeFiles/SudokuSolver.dir/main.cpp.obj.provides: CMakeFiles/SudokuSolver.dir/main.cpp.obj.requires
	$(MAKE) -f CMakeFiles\SudokuSolver.dir\build.make CMakeFiles/SudokuSolver.dir/main.cpp.obj.provides.build
.PHONY : CMakeFiles/SudokuSolver.dir/main.cpp.obj.provides

CMakeFiles/SudokuSolver.dir/main.cpp.obj.provides.build: CMakeFiles/SudokuSolver.dir/main.cpp.obj


CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj: CMakeFiles/SudokuSolver.dir/flags.make
CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj: ../SudokuSolver.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\Krishna\CLionProjects\SudokuSolver\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\SudokuSolver.dir\SudokuSolver.cpp.obj -c C:\Users\Krishna\CLionProjects\SudokuSolver\SudokuSolver.cpp

CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.i"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\Users\Krishna\CLionProjects\SudokuSolver\SudokuSolver.cpp > CMakeFiles\SudokuSolver.dir\SudokuSolver.cpp.i

CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.s"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\Users\Krishna\CLionProjects\SudokuSolver\SudokuSolver.cpp -o CMakeFiles\SudokuSolver.dir\SudokuSolver.cpp.s

CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj.requires:

.PHONY : CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj.requires

CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj.provides: CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj.requires
	$(MAKE) -f CMakeFiles\SudokuSolver.dir\build.make CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj.provides.build
.PHONY : CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj.provides

CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj.provides.build: CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj


# Object files for target SudokuSolver
SudokuSolver_OBJECTS = \
"CMakeFiles/SudokuSolver.dir/main.cpp.obj" \
"CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj"

# External object files for target SudokuSolver
SudokuSolver_EXTERNAL_OBJECTS =

SudokuSolver.exe: CMakeFiles/SudokuSolver.dir/main.cpp.obj
SudokuSolver.exe: CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj
SudokuSolver.exe: CMakeFiles/SudokuSolver.dir/build.make
SudokuSolver.exe: CMakeFiles/SudokuSolver.dir/linklibs.rsp
SudokuSolver.exe: CMakeFiles/SudokuSolver.dir/objects1.rsp
SudokuSolver.exe: CMakeFiles/SudokuSolver.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\Users\Krishna\CLionProjects\SudokuSolver\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX executable SudokuSolver.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\SudokuSolver.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/SudokuSolver.dir/build: SudokuSolver.exe

.PHONY : CMakeFiles/SudokuSolver.dir/build

CMakeFiles/SudokuSolver.dir/requires: CMakeFiles/SudokuSolver.dir/main.cpp.obj.requires
CMakeFiles/SudokuSolver.dir/requires: CMakeFiles/SudokuSolver.dir/SudokuSolver.cpp.obj.requires

.PHONY : CMakeFiles/SudokuSolver.dir/requires

CMakeFiles/SudokuSolver.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\SudokuSolver.dir\cmake_clean.cmake
.PHONY : CMakeFiles/SudokuSolver.dir/clean

CMakeFiles/SudokuSolver.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\Krishna\CLionProjects\SudokuSolver C:\Users\Krishna\CLionProjects\SudokuSolver C:\Users\Krishna\CLionProjects\SudokuSolver\cmake-build-debug C:\Users\Krishna\CLionProjects\SudokuSolver\cmake-build-debug C:\Users\Krishna\CLionProjects\SudokuSolver\cmake-build-debug\CMakeFiles\SudokuSolver.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/SudokuSolver.dir/depend

