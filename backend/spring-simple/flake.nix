{
  description = "Example Todo app backend in Spring";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";
    utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, utils, ... }@inputs:
    utils.lib.eachDefaultSystem (system:
      let
        pkgs = import nixpkgs {
          config.allowUnfree = true;
          inherit system;
        };
      in rec {
        devShells.default =
          pkgs.mkShell rec { packages = with pkgs; [ jdk17 maven ]; };
      });
}
