{
  description = "Example Todo app backend in Django using Django Rest Framework";

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
        devShells.default = pkgs.mkShell rec {
          packages = with pkgs; [
            python310Full
            python310Packages.django
            python310Packages.djangorestframework
            python310Packages.pip

          ];
        };
      });
}
