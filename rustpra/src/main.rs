use std::collections::HashMap;
use ferris_says::say; // from the previous step
use std::io::{stdout, BufWriter};
use serde_json::to_string;

fn main() {
    let stdout = stdout();
    let message = String::from("Hello World!");
    let width = message.chars().count();
    let mut writer = BufWriter::new(stdout.lock());
    say(message.as_bytes(), width, &mut writer).unwrap();
}

