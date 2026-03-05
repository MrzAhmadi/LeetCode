#!/bin/sh

if [ -z "$1" ]; then
  echo "Usage: $0 \"<problem_name>\""
  exit 1
fi

formatted_name=$(echo "$1" | tr '[:upper:]' '[:lower:]' | sed 's/\.//g' | tr ' ' '_')
folder_name="p_${formatted_name}"

mkdir -p "$folder_name"

file_path="${folder_name}/Main.kt"

echo "package ${folder_name}" > "$file_path"
echo "" >> "$file_path"
echo "// Problem link : " >> "$file_path"

echo "Created directory: $folder_name"
echo "Created file: $file_path"